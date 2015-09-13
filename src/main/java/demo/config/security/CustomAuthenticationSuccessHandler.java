package demo.config.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import demo.Application;
import demo.mapper.AccountMapper;
import demo.model.Account;
import demo.model.AccountRole;

@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	private RequestCache requestCache = new HttpSessionRequestCache();
	@Autowired
	AccountMapper accountMapper;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
		String targetUrlParameter = getTargetUrlParameter();
		if (isAlwaysUseDefaultTargetUrl() || (targetUrlParameter != null && StringUtils.hasText(request.getParameter(targetUrlParameter)))) {
			requestCache.removeRequest(request, response);
		}

		clearAuthenticationAttributes(request);

		Object principal = authentication.getPrincipal();
		if (principal instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) principal;
			Account account = accountMapper.selectByUserName(userDetails.getUsername());
			if (account == null) {
				account = new Account();
				account.setUserName(userDetails.getUsername());
				List<AccountRole> accountRoles = new ArrayList<AccountRole>();
				for (GrantedAuthority authority : userDetails.getAuthorities()) {
					AccountRole accountRole = new AccountRole();
					accountRole.setUserName(userDetails.getUsername());
					accountRole.setRole(authority.getAuthority());
					accountRoles.add(accountRole);
				}
				account.setAccountRoles(accountRoles.toArray(new AccountRole[0]));
			}
			HttpSession session = request.getSession(true);
			session.setAttribute(Application.LOGIN_ACCOUNT_SESSION_KEY, account);
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			new ObjectMapper().writeValue(response.getWriter(), account);
		}
	}

	public void setRequestCache(RequestCache requestCache) {
		this.requestCache = requestCache;
	}
}
