package com.rendyrobbani.keuangan.application.web.mapper.user;

import com.rendyrobbani.keuangan.application.web.record.user.WebUserDetailResponseRecord;
import com.rendyrobbani.keuangan.application.web.record.user.WebUserSelectResponseRecord;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserCreateRequest;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserUpdateRequest;
import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDetailResponse;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserSelectResponse;
import com.rendyrobbani.keuangan.domain.model.entity.user.DataUserRecord;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WebUserMapper {

	public static WebUserSelectResponse toSelectResponse(DataUser domain) {
		return new WebUserSelectResponseRecord(domain.id(),
		                                       domain.simpleNip(),
		                                       domain.styledNip(),
		                                       domain.pangkatTitle(),
		                                       domain.onlyName(false),
		                                       domain.fullName(false),
		                                       domain.isLocked(),
		                                       domain.isDeleted());
	}

	public static WebUserDetailResponse toDetailResponse(DataUser domain) {
		return new WebUserDetailResponseRecord(domain.id(),
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

	public static DataUser toDomain(WebUserCreateRequest request, String password) {
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

	public static DataUser toDomain(WebUserUpdateRequest request, DataUser domain) {
		return new DataUserRecord(domain.nip().simple(),
		                          domain.nip(),
		                          request.pangkat(),
		                          request.name(),
		                          request.titlePrefix(),
		                          request.titleSuffix(),
		                          domain.password(),
		                          domain.nip().dateOfBirth(),
		                          request.pangkat().isPNS() ? domain.nip().dateOfStart() : request.dateOfStart(),
		                          domain.nip().gender(),
		                          domain.nip().number(),
		                          request.pangkat().isPNS(),
		                          request.pangkat().isP3K(),
		                          domain.isLocked(),
		                          domain.isDeleted()
		);
	}

}