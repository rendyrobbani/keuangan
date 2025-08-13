package com.rendyrobbani.keuangan.application.web.service.user;

import com.rendyrobbani.keuangan.application.web.mapper.user.WebUserDataMapper;
import com.rendyrobbani.keuangan.common.exception.http.NotFoundException;
import com.rendyrobbani.keuangan.domain.model.response.web.user.data.WebUserDataDetailResponse;
import com.rendyrobbani.keuangan.domain.model.response.web.user.data.WebUserDataSelectResponse;
import com.rendyrobbani.keuangan.domain.port.incoming.web.user.WebUserDataSelectService;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebUserDataSelectServiceImpl implements WebUserDataSelectService {

	private final DataUserRepository repository;

	public WebUserDataSelectServiceImpl(DataUserRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<WebUserDataSelectResponse> selectAll() {
		return this.repository.selectAll().stream().map(WebUserDataMapper::toSelectResponse).toList();
	}

	@Override
	public WebUserDataDetailResponse selectById(String id) {
		return this.repository.selectById(id).map(WebUserDataMapper::toDetailResponse).orElseThrow(NotFoundException::new);
	}

}