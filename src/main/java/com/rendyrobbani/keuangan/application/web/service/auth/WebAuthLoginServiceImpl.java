package com.rendyrobbani.keuangan.application.web.service.auth;

import com.rendyrobbani.keuangan.application.web.record.auth.WebAuthLoginResponseRecord;
import com.rendyrobbani.keuangan.common.exception.http.UnauthorizedException;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthLoginRequest;
import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthLoginResponse;
import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.model.vo.Role;
import com.rendyrobbani.keuangan.domain.port.incoming.web.auth.WebAuthLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebAuthLoginServiceImpl implements WebAuthLoginService {

	private final DataUser admin;

	private final WebJwtService webJwtService;

	@Override
	public WebAuthLoginResponse handle(WebAuthLoginRequest request) {
		return switch (request.role()) {
			case ADMIN -> loginAsAdministrator();
			default -> throw new UnauthorizedException("Role not found");
		};
	}

	private WebAuthLoginResponse loginAsAdministrator() {
		var user = webJwtService.getUser();
		if (user.id().equals(admin.id())) {
			webJwtService.setToken(user, Role.ADMIN);
			return toResponse(user);
		}
		throw new UnauthorizedException();
	}

	private WebAuthLoginResponse toResponse(DataUser user) {
		return new WebAuthLoginResponseRecord(user.simpleNip(),
		                                      user.styledNip(),
		                                      user.pangkatValue(),
		                                      user.pangkatTitle(),
		                                      user.onlyName(false),
		                                      user.fullName(false),
		                                      user.titlePrefix(),
		                                      user.titleSuffix(),
		                                      user.dateOfBirth(),
		                                      user.dateOfStart(),
		                                      user.gender(),
		                                      user.number());
	}

}