package com.rendyrobbani.keuangan.application.web.service.user;

import com.rendyrobbani.keuangan.application.web.mapper.user.WebUserMapper;
import com.rendyrobbani.keuangan.common.exception.http.NotFoundException;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataDetailResponse;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataSelectResponse;
import com.rendyrobbani.keuangan.domain.port.incoming.web.user.WebUserDataSelectService;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebUserDataSelectServiceImpl implements WebUserDataSelectService {

	private final DataUserRepository repository;

	@Override
	public List<WebUserDataSelectResponse> selectAll() {
		return this.repository.selectAll().stream().map(WebUserMapper::toSelectResponse).toList();
	}

	@Override
	public WebUserDataDetailResponse selectById(String id) {
		return this.repository.selectById(id).map(WebUserMapper::toDetailResponse).orElseThrow(NotFoundException::new);
	}

}