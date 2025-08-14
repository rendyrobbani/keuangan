package com.rendyrobbani.keuangan.application.web.service.user;

import com.rendyrobbani.keuangan.application.web.mapper.user.WebUserMapper;
import com.rendyrobbani.keuangan.common.exception.http.NotFoundException;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDetailResponse;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserSelectResponse;
import com.rendyrobbani.keuangan.domain.port.incoming.web.user.WebUserSelectService;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebUserSelectServiceImpl implements WebUserSelectService {

	private final WebJwtService webJwtService;

	private final DataUserRepository repository;

	@Override
	public List<WebUserSelectResponse> selectAll() {
		var response = this.repository.selectAll().stream().map(WebUserMapper::toSelectResponse).toList();
		if (webJwtService.isAdmin()) return response;
		return response.stream().filter(e -> !e.isDeleted()).toList();
	}

	@Override
	public WebUserDetailResponse selectById(String id) {
		var response = this.repository.selectById(id).map(WebUserMapper::toDetailResponse).orElseThrow(NotFoundException::new);
		if (response.isDeleted()) {
			if (webJwtService.isAdmin()) return response;
			throw new NotFoundException();
		}
		return response;
	}

}