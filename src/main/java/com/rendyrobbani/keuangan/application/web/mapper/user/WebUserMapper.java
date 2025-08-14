package com.rendyrobbani.keuangan.application.web.mapper.user;

import com.rendyrobbani.keuangan.application.web.record.user.WebUserDataDetailResponseRecord;
import com.rendyrobbani.keuangan.application.web.record.user.WebUserDataSelectResponseRecord;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataCreateRequest;
import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataDetailResponse;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataSelectResponse;
import com.rendyrobbani.keuangan.domain.model.entity.user.DataUserRecord;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WebUserMapper {

	public static WebUserDataSelectResponse toSelectResponse(DataUser domain) {
		return new WebUserDataSelectResponseRecord(domain.id(),
		                                           domain.simpleNip(),
		                                           domain.styledNip(),
		                                           domain.pangkatTitle(),
		                                           domain.onlyName(false),
		                                           domain.fullName(false),
		                                           domain.isLocked(),
		                                           domain.isDeleted());
	}

	public static WebUserDataDetailResponse toDetailResponse(DataUser domain) {
		return new WebUserDataDetailResponseRecord(domain.id(),
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

	public static DataUser toDomain(WebUserDataCreateRequest request, String password) {
		return new DataUserRecord(request.nip().simple(),
		                          request.nip(),
		                          request.pangkat(),
		                          request.name(),
		                          request.titlePrefix(),
		                          request.titleSuffix(),
		                          password,
		                          request.nip().dateOfBirth(),
		                          request.pangkat().isPNS() ? request.nip().dateOfStart() : request.dateOfStart(),
		                          request.nip().gender(),
		                          request.nip().number(),
		                          request.pangkat().isPNS(),
		                          request.pangkat().isP3K(),
		                          false,
		                          false
		);
	}

}