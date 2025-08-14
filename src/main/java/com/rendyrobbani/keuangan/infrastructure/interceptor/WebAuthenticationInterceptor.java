package com.rendyrobbani.keuangan.infrastructure.interceptor;

import com.rendyrobbani.keuangan.domain.auth.WebJwtPayload;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WebAuthenticationInterceptor implements HandlerInterceptor {

	private final List<String> whitelist = List.of(
			"POST/web/auth/prelogin"
	);

	private final WebJwtService webJwtService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		if (request.getRequestURI().startsWith("/api/")) return apiHandle(request, response);
		if (request.getRequestURI().startsWith("/web/")) return webHandle(request, response);
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return false;
	}

	private boolean apiHandle(HttpServletRequest request, HttpServletResponse response) {
		return false;
	}

	private boolean webHandle(HttpServletRequest request, HttpServletResponse response) {
		String method = request.getMethod().toUpperCase();
		String uri = request.getRequestURI();

		if (method.equals("OPTIONS")) {
			response.setStatus(HttpServletResponse.SC_OK);
			return true;
		}

		if (whitelist.contains(method + uri)) return true;

		String token = request.getHeader("Authorization") != null && request.getHeader("Authorization").length() >= 7 ? request.getHeader("Authorization").substring(7) : null;
		if (token == null) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		}

		WebJwtPayload payload = webJwtService.decode(token);
		if (payload == null) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		} else {
			webJwtService.setToken(payload);
			return true;
		}
	}

}