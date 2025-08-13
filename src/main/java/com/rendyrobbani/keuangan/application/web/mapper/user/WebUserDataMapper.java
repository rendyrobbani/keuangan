package com.rendyrobbani.keuangan.application.web.mapper.user;

import com.rendyrobbani.keuangan.application.web.mapper.user.record.WebUserDataDetailRecord;
import com.rendyrobbani.keuangan.application.web.mapper.user.record.WebUserDataSelectRecord;
import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.model.response.web.user.data.WebUserDataDetailResponse;
import com.rendyrobbani.keuangan.domain.model.response.web.user.data.WebUserDataSelectResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WebUserDataMapper {

	public static WebUserDataSelectResponse toSelectResponse(DataUser domain) {
		return new WebUserDataSelectRecord(domain.id(),
		                                   domain.simpleNip(),
		                                   domain.styledNip(),
		                                   domain.pangkatTitle(),
		                                   domain.onlyName(false),
		                                   domain.fullName(false),
		                                   domain.isLocked(),
		                                   domain.isDeleted());
	}

	public static WebUserDataDetailResponse toDetailResponse(DataUser domain) {
		return new WebUserDataDetailRecord(domain.id(),
		                                   domain.simpleNip(),
		                                   domain.styledNip(),
		                                   domain.pangkatValue(),
		                                   domain.pangkatTitle(),
		                                   domain.onlyName(false),
		                                   domain.fullName(false),
		                                   domain.titlePrefix(),
		                                   domain.titleSuffix(),
		                                   domain.dateOfBirth(),
		                                   domain.dateOfStart(),
		                                   domain.gender(),
		                                   domain.number(),
		                                   domain.isPNS(),
		                                   domain.isP3K(),
		                                   domain.isLocked(),
		                                   domain.isDeleted());
	}

}