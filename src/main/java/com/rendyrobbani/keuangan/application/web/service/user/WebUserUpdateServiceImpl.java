package com.rendyrobbani.keuangan.application.web.service.user;

import com.rendyrobbani.keuangan.application.web.mapper.user.WebUserMapper;
import com.rendyrobbani.keuangan.common.exception.http.BadRequestException;
import com.rendyrobbani.keuangan.common.exception.http.NotFoundException;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserUpdateRequest;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDetailResponse;
import com.rendyrobbani.keuangan.domain.port.incoming.web.user.WebUserUpdateService;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.LogsUserRepository;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WebUserUpdateServiceImpl implements WebUserUpdateService {

	private final WebJwtService webJwtService;

	private final Validator validator;

	private final DataUserRepository dataRepository;

	private final LogsUserRepository logsRepository;

	@Override
	@Transactional
	public WebUserDetailResponse update(String id, WebUserUpdateRequest request) {
		var domain = dataRepository.selectById(id).orElseThrow(NotFoundException::new);
		if (domain.isDeleted()) throw new NotFoundException();

		var actionAt = LocalDateTime.now();
		var actionBy = webJwtService.getToken().user().nip();

		var violations = validator.validate(request);
		if (!violations.isEmpty()) throw new BadRequestException(violations);
		else {
			domain = WebUserMapper.toDomain(request, domain);
			domain = dataRepository.update(domain, actionAt, actionBy);
			logsRepository.create(domain.toLog(), actionAt, actionBy);
			return WebUserMapper.toDetailResponse(domain);
		}
	}

}