package com.rendyrobbani.keuangan.domain.port.incoming.web.user;

import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDetailResponse;

public interface WebUserLockedService {

	WebUserDetailResponse lock(String id);

	WebUserDetailResponse unlock(String id);

}