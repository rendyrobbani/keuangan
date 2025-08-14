package com.rendyrobbani.keuangan.application.web.service.master.fungsi;

import com.rendyrobbani.keuangan.application.web.mapper.master.fungsi.WebMasterFungsiMapper;
import com.rendyrobbani.keuangan.common.exception.http.BadRequestException;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiCreateRequest;
import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiDetailResponse;
import com.rendyrobbani.keuangan.domain.port.incoming.web.master.fungsi.WebMasterFungsiCreateService;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.master.codes.fungsi.DataMasterFungsiRepository;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class WebMasterFungsiCreateServiceImpl implements WebMasterFungsiCreateService {

	private final WebJwtService webJwtService;

	private final Validator validator;

	private final DataMasterFungsiRepository repository;

	@Override
	public WebMasterFungsiDetailResponse create(WebMasterFungsiCreateRequest request) {
		var violations = validator.validate(request);
		if (!violations.isEmpty()) throw new BadRequestException(violations);
		else {
			var actionAt = LocalDateTime.now();
			var actionBy = webJwtService.getUser().nip();

			var domain = repository.selectById(request.code().fungsiCode()).orElse(null);
			if (domain != null) {
				if (domain.isDeleted()) return WebMasterFungsiMapper.toDetailResponse(repository.restore(domain, actionAt, actionBy));
				else throw new BadRequestException(Map.of("code", List.of("sudah digunakan")));
			}

			return WebMasterFungsiMapper.toDetailResponse(repository.create(WebMasterFungsiMapper.toDomain(request), actionAt, actionBy));
		}
	}

}