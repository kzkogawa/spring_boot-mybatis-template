package demo.config.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.CookieGenerator;
import org.springframework.web.util.WebUtils;

import demo.CustomHttpServletRequestWrapper;

public class FilterFactory {
	private static final Logger log = LoggerFactory.getLogger(FilterFactory.class);
	private static final String DEFAULT_CSRF_PARAMETER_NAME = "_csrf";
	private static final String DEFAULT_CSRF_HEADER_NAME = "X-CSRF-TOKEN";

	/**
	 * obtain csrf-token from cookie and set it to request header
	 * 
	 * @return
	 */
	public static Filter createBeforCsrfFilter() {
		return new OncePerRequestFilter() {
			@Override
			protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
				Cookie cookie = WebUtils.getCookie(request, DEFAULT_CSRF_HEADER_NAME);
				if (cookie == null) {
					cookie = WebUtils.getCookie(request, DEFAULT_CSRF_PARAMETER_NAME);
				}

				CustomHttpServletRequestWrapper customHttpServletRequestWrapper = new CustomHttpServletRequestWrapper(request);
				if (cookie != null) {
					log.debug("{}", cookie);
					customHttpServletRequestWrapper.putHeader(DEFAULT_CSRF_HEADER_NAME, cookie.getValue());
				}
				filterChain.doFilter(customHttpServletRequestWrapper, response);
			}
		};
	}

	/**
	 * obtain csrf-token from request attribute and set it to cookie
	 * 
	 * @return
	 */
	public static Filter createAfterCsrfFilter() {
		return new OncePerRequestFilter() {
			@Override
			protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
				saveCsrfTokenCookie(request, response);
				filterChain.doFilter(request, response);
			}
		};
	}

	public static void saveCsrfTokenCookie(HttpServletRequest request, HttpServletResponse response) {
		CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
		log.debug("{}", csrfToken);
		CookieGenerator cookieGenerator = new CookieGenerator();
		cookieGenerator.setCookieName(DEFAULT_CSRF_HEADER_NAME);
		cookieGenerator.addCookie(response, csrfToken.getToken());
	}
}
