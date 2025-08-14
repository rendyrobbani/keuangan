package com.rendyrobbani.keuangan.application.web.service.master.fungsi;

import com.rendyrobbani.keuangan.application.web.mapper.master.fungsi.WebMasterFungsiMapper;
import com.rendyrobbani.keuangan.common.exception.http.BadRequestException;
import com.rendyrobbani.keuangan.common.exception.http.NotFoundException;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiUpdateRequest;
import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiDetailResponse;
import com.rendyrobbani.keuangan.domain.port.incoming.web.master.fungsi.WebMasterFungsiUpdateService;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.master.codes.fungsi.DataMasterFungsiRepository;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WebMasterFungsiUpdateServiceImpl implements WebMasterFungsiUpdateService {

	private final WebJwtService webJwtService;

	private final Validator validator;

	private final DataMasterFungsiRepository repository;

	@Override
	public WebMasterFungsiDetailResponse update(String id, WebMasterFungsiUpdateRequest request) {
		var domain = repository.selectById(id).orElseThrow(NotFoundException::new);
		if (domain.isDeleted() && !webJwtService.isAdmin()) throw new NotFoundException();

		var violations = validator.validate(request);
		if (!violations.isEmpty()) throw new BadRequestException(violations);
		else {
			var actionAt = LocalDateTime.now();
			var actionBy = webJwtService.getUser().nip();

			return WebMasterFungsiMapper.toDetailResponse(repository.update(WebMasterFungsiMapper.toDomain(request, domain), actionAt, actionBy));
		}
	}

}