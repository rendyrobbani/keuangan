package com.rendyrobbani.keuangan.application.web.service.master.fungsi;

import com.rendyrobbani.keuangan.application.web.mapper.master.fungsi.WebMasterFungsiMapper;
import com.rendyrobbani.keuangan.common.exception.http.NotFoundException;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiDetailResponse;
import com.rendyrobbani.keuangan.domain.port.incoming.web.master.fungsi.WebMasterFungsiLockedService;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.master.codes.fungsi.DataMasterFungsiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WebMasterFungsiLockedServiceImpl implements WebMasterFungsiLockedService {

	private final WebJwtService webJwtService;

	private final DataMasterFungsiRepository repository;

	@Override
	public WebMasterFungsiDetailResponse lock(String id) {
		var domain = repository.selectById(id).orElseThrow(NotFoundException::new);
		if (domain.isDeleted() && !webJwtService.isAdmin()) throw new NotFoundException();
		if (domain.isLocked()) return WebMasterFungsiMapper.toDetailResponse(domain);

		var actionAt = LocalDateTime.now();
		var actionBy = webJwtService.getUser().nip();

		return WebMasterFungsiMapper.toDetailResponse(repository.lock(domain, actionAt, actionBy));
	}

	@Override
	public WebMasterFungsiDetailResponse unlock(String id) {
		var domain = repository.selectById(id).orElseThrow(NotFoundException::new);
		if (domain.isDeleted() && !webJwtService.isAdmin()) throw new NotFoundException();
		if (!domain.isLocked()) return WebMasterFungsiMapper.toDetailResponse(domain);

		var actionAt = LocalDateTime.now();
		var actionBy = webJwtService.getUser().nip();

		return WebMasterFungsiMapper.toDetailResponse(repository.unlock(domain, actionAt, actionBy));
	}

}