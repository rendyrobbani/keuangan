package com.rendyrobbani.keuangan.domain.port.incoming.web.user;

import com.rendyrobbani.keuangan.domain.model.response.web.user.data.WebUserDataDetailResponse;
import com.rendyrobbani.keuangan.domain.model.response.web.user.data.WebUserDataSelectResponse;

import java.util.List;

public interface WebUserDataSelectService {

	List<WebUserDataSelectResponse> selectAll();

	WebUserDataDetailResponse selectById(String id);

}