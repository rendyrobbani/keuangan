package com.rendyrobbani.keuangan.application.web.service.user;

import com.rendyrobbani.keuangan.application.web.mapper.user.WebUserMapper;
import com.rendyrobbani.keuangan.common.exception.http.NotFoundException;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDetailResponse;
import com.rendyrobbani.keuangan.domain.port.incoming.web.user.WebUserDeleteService;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.LogsUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WebUserDeleteServiceImpl implements WebUserDeleteService {

	private final WebJwtService webJwtService;

	private final DataUserRepository dataRepository;

	private final LogsUserRepository logsRepository;

	@Override
	public WebUserDetailResponse delete(String id) {
		var domain = dataRepository.selectById(id).orElseThrow(NotFoundException::new);
		if (domain.isDeleted()) return WebUserMapper.toDetailResponse(domain);

		var actionAt = LocalDateTime.now();
		var actionBy = webJwtService.getToken().user().nip();

		domain = dataRepository.delete(domain, actionAt, actionBy);
		logsRepository.create(domain.toLog(), actionAt, actionBy);
		return WebUserMapper.toDetailResponse(domain);
	}

	@Override
	public WebUserDetailResponse restore(String id) {
		var domain = dataRepository.selectById(id).orElseThrow(NotFoundException::new);
		if (!domain.isDeleted()) return WebUserMapper.toDetailResponse(domain);

		var actionAt = LocalDateTime.now();
		var actionBy = webJwtService.getToken().user().nip();

		domain = dataRepository.restore(domain, actionAt, actionBy);
		logsRepository.create(domain.toLog(), actionAt, actionBy);
		return WebUserMapper.toDetailResponse(domain);
	}

}