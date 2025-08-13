package com.rendyrobbani.keuangan.application.web.service.auth;

import com.rendyrobbani.keuangan.application.web.record.auth.WebAuthPreloginResponseRecord;
import com.rendyrobbani.keuangan.common.exception.http.BadRequestException;
import com.rendyrobbani.keuangan.common.exception.http.UnauthorizedException;
import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthPreloginRequest;
import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthPreloginResponse;
import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.port.incoming.web.auth.WebAuthPreloginService;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import jakarta.validation.Validator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class WebAuthPreloginServiceImpl implements WebAuthPreloginService {

	private final DataUser admin;

	private final Validator validator;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final DataUserRepository userRepository;

	public WebAuthPreloginServiceImpl(DataUser admin,
	                                  Validator validator,
	                                  BCryptPasswordEncoder bCryptPasswordEncoder,
	                                  DataUserRepository userRepository) {
		this.admin = admin;
		this.validator = validator;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userRepository = userRepository;
	}

	@Override
	public WebAuthPreloginResponse prelogin(WebAuthPreloginRequest request) {
		var violations = validator.validate(request);
		if (!violations.isEmpty()) throw new BadRequestException(violations);
		else {
			var user = userRepository.selectById(request.username()).orElseThrow(UnauthorizedException::new);
			if (user.id().equals(admin.id())) {
				//TODO: Prelogin as Admin
				return new WebAuthPreloginResponseRecord(user.onlyName(false), user.fullName(false));
			} else {
				if (user.isLocked()) throw new UnauthorizedException();
				if (user.isDeleted()) throw new UnauthorizedException();
				if (!bCryptPasswordEncoder.matches(user.password(), request.password())) throw new UnauthorizedException();

				return new WebAuthPreloginResponseRecord(user.onlyName(false), user.fullName(false));
			}
		}
	}

}