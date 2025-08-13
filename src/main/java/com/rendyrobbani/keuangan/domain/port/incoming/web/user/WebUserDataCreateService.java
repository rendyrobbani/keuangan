package com.rendyrobbani.keuangan.domain.port.incoming.web.user;

import com.rendyrobbani.keuangan.domain.model.dto.web.user.data.WebUserDataCreateRequest;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.data.WebUserDataDetailResponse;

public interface WebUserDataCreateService {

	WebUserDataDetailResponse create(WebUserDataCreateRequest request);

}