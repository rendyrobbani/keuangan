package com.rendyrobbani.keuangan.application.web.service.auth;

import com.rendyrobbani.keuangan.application.web.record.auth.WebAuthPreloginResponseRecord;
import com.rendyrobbani.keuangan.application.web.record.auth.WebAuthPreloginResponseRecordOfRole;
import com.rendyrobbani.keuangan.common.exception.http.BadRequestException;
import com.rendyrobbani.keuangan.common.exception.http.UnauthorizedException;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthPreloginRequest;
import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthPreloginResponse;
import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthPreloginResponseOfRole;
import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.model.vo.Role;
import com.rendyrobbani.keuangan.domain.port.incoming.web.auth.WebAuthPreloginService;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class WebAuthPreloginServiceImpl implements WebAuthPreloginService {

	private final DataUser admin;

	private final WebJwtService webJwtService;

	private final Validator validator;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final DataUserRepository userRepository;

	@Override
	public WebAuthPreloginResponse prelogin(WebAuthPreloginRequest request) {
		var violations = validator.validate(request);
		if (!violations.isEmpty()) throw new BadRequestException(violations);
		else {
			var user = userRepository.selectById(request.username()).orElseThrow(UnauthorizedException::new);
			if (user.id().equals(admin.id())) {
				var listOfRole = new ArrayList<WebAuthPreloginResponseOfRole>();
				listOfRole.add(new WebAuthPreloginResponseRecordOfRole(Role.ADMIN.value(), Role.ADMIN.title()));

				webJwtService.setToken(user);
				return new WebAuthPreloginResponseRecord(user.onlyName(false), user.fullName(false), listOfRole);
			} else {
				if (user.isLocked()) throw new UnauthorizedException();
				if (user.isDeleted()) throw new UnauthorizedException();
				if (!bCryptPasswordEncoder.matches(user.password(), request.password())) throw new UnauthorizedException();

				var listOfRole = new ArrayList<WebAuthPreloginResponseOfRole>();
				listOfRole.add(new WebAuthPreloginResponseRecordOfRole(Role.ADMIN.value(), Role.ADMIN.title()));

				return new WebAuthPreloginResponseRecord(user.onlyName(false), user.fullName(false), listOfRole);
			}
		}
	}

}