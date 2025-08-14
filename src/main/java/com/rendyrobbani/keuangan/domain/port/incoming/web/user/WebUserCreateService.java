package com.rendyrobbani.keuangan.domain.port.incoming.web.user;

import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserCreateRequest;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDetailResponse;

public interface WebUserCreateService {

	WebUserDetailResponse create(WebUserCreateRequest request);

}