package com.rendyrobbani.keuangan.application.web.service.user;

import com.rendyrobbani.keuangan.application.web.mapper.user.WebUserMapper;
import com.rendyrobbani.keuangan.common.exception.http.NotFoundException;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataDetailResponse;
import com.rendyrobbani.keuangan.domain.port.incoming.web.user.WebUserDataLockedService;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.LogsUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WebUserDataLockedServiceImpl implements WebUserDataLockedService {

	private final WebJwtService webJwtService;

	private final DataUserRepository dataRepository;

	private final LogsUserRepository logsRepository;

	@Override
	public WebUserDataDetailResponse lock(String id) {
		var actionAt = LocalDateTime.now();
		var actionBy = webJwtService.getToken().user().nip();

		var domain = dataRepository.selectById(id).orElseThrow(NotFoundException::new);
		if (domain.isDeleted() && !webJwtService.isAdmin()) throw new NotFoundException();
		if (domain.isLocked()) return WebUserMapper.toDetailResponse(domain);
		domain = dataRepository.delete(domain, actionAt, actionBy);
		logsRepository.create(domain.toLog(), actionAt, actionBy);
		return WebUserMapper.toDetailResponse(domain);
	}

	@Override
	public WebUserDataDetailResponse unlock(String id) {
		var actionAt = LocalDateTime.now();
		var actionBy = webJwtService.getToken().user().nip();

		var domain = dataRepository.selectById(id).orElseThrow(NotFoundException::new);
		if (domain.isDeleted() && !webJwtService.isAdmin()) throw new NotFoundException();
		if (!domain.isLocked()) return WebUserMapper.toDetailResponse(domain);
		domain = dataRepository.restore(domain, actionAt, actionBy);
		logsRepository.create(domain.toLog(), actionAt, actionBy);
		return WebUserMapper.toDetailResponse(domain);
	}

}