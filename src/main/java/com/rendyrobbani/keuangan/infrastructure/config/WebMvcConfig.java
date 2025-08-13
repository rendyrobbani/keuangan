package com.rendyrobbani.keuangan.infrastructure.config;

import com.rendyrobbani.keuangan.infrastructure.interceptor.WebAuthenticationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	private final WebAuthenticationInterceptor webAuthenticationInterceptor;

	public WebMvcConfig(WebAuthenticationInterceptor webAuthenticationInterceptor) {
		this.webAuthenticationInterceptor = webAuthenticationInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(webAuthenticationInterceptor);
	}

}