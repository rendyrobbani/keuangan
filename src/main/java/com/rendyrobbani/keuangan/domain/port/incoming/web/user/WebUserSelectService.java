package com.rendyrobbani.keuangan.domain.port.incoming.web.user;

import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDetailResponse;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserSelectResponse;

import java.util.List;

public interface WebUserSelectService {

	List<WebUserSelectResponse> selectAll();

	WebUserDetailResponse selectById(String id);

}