package com.rendyrobbani.keuangan.application.web.service.master.fungsi;

import com.rendyrobbani.keuangan.application.web.mapper.master.fungsi.WebMasterFungsiMapper;
import com.rendyrobbani.keuangan.common.exception.http.NotFoundException;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiDetailResponse;
import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiSelectResponse;
import com.rendyrobbani.keuangan.domain.port.incoming.web.master.fungsi.WebMasterFungsiSelectService;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.master.codes.fungsi.DataMasterFungsiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebMasterFungsiSelectServiceImpl implements WebMasterFungsiSelectService {

	private final WebJwtService webJwtService;

	private final DataMasterFungsiRepository repository;

	@Override
	public List<WebMasterFungsiSelectResponse> selectAll() {
		var response = repository.selectAll().stream().map(WebMasterFungsiMapper::toSelectResponse).toList();
		if (webJwtService.isAdmin()) return response;
		return response.stream().filter(e -> !e.isDeleted()).toList();
	}

	@Override
	public WebMasterFungsiDetailResponse selectById(String id) {
		var response = repository.selectById(id).map(WebMasterFungsiMapper::toDetailResponse).orElseThrow(NotFoundException::new);
		if (response.isDeleted() && !webJwtService.isAdmin()) throw new NotFoundException();
		return response;
	}

}