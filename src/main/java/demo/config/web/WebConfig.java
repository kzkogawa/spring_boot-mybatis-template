package demo.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import demo.controller.interceptor.LoggingInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);

		registry.addInterceptor(new LoggingInterceptor());
	}
}
