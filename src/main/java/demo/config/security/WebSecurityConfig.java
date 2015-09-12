package demo.config.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private String usersByUsernameQuery = "SELECT user_name as username, password, true as enabled FROM account WHERE user_name = ?";
	private String authoritiesByUsernameQuery = "SELECT user_name as username, 'user' as authority FROM account WHERE user_name = ?";
	@Autowired
	private DataSource dataSource;
	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;
	@Autowired
	private AccessDeniedHandler accessDeniedHandler;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new StandardPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder()).usersByUsernameQuery(usersByUsernameQuery).authoritiesByUsernameQuery(authoritiesByUsernameQuery);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated();
		http.formLogin();
		http.logout();
		http.httpBasic();
		http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
		http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
		http.addFilterBefore(FilterFactory.createBeforCsrfFilter(), CsrfFilter.class);
		http.addFilterAfter(FilterFactory.createAfterCsrfFilter(), CsrfFilter.class);
	}
}