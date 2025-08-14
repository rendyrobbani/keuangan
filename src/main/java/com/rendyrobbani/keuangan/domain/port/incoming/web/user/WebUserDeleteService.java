package com.rendyrobbani.keuangan.domain.port.incoming.web.user;

import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDetailResponse;

public interface WebUserDeleteService {

	WebUserDetailResponse delete(String id);

	WebUserDetailResponse restore(String id);

}