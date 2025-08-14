package com.rendyrobbani.keuangan.domain.port.incoming.web.user;

import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserUpdateRequest;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDetailResponse;

public interface WebUserUpdateService {

	WebUserDetailResponse update(String id, WebUserUpdateRequest request);

}