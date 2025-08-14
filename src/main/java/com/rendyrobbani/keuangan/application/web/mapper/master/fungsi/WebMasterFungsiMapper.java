package com.rendyrobbani.keuangan.application.web.mapper.master.fungsi;

import com.rendyrobbani.keuangan.application.web.record.master.fungsi.WebMasterFungsiDetailResponseRecord;
import com.rendyrobbani.keuangan.application.web.record.master.fungsi.WebMasterFungsiSelectResponseRecord;
import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiCreateRequest;
import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiDetailResponse;
import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiSelectResponse;
import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiUpdateRequest;
import com.rendyrobbani.keuangan.domain.model.entity.master.codes.fungsi.DataMasterFungsi;
import com.rendyrobbani.keuangan.domain.model.entity.master.codes.fungsi.DataMasterFungsiRecord;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WebMasterFungsiMapper {

	public static WebMasterFungsiSelectResponse toSelectResponse(DataMasterFungsi domain) {
		return new WebMasterFungsiSelectResponseRecord(domain.id(),
		                                               domain.code(),
		                                               domain.name(),
		                                               domain.isLocked(),
		                                               domain.isDeleted());
	}

	public static WebMasterFungsiDetailResponse toDetailResponse(DataMasterFungsi domain) {
		return new WebMasterFungsiDetailResponseRecord(domain.id(),
		                                               domain.code(),
		                                               domain.name(),
		                                               domain.isLocked(),
		                                               domain.isDeleted());
	}

	public static DataMasterFungsi toDomain(WebMasterFungsiCreateRequest request) {
		return new DataMasterFungsiRecord(request.code().fungsiCode(),
		                                  request.code().fungsiCode(),
		                                  request.name(),
		                                  false,
		                                  false);
	}

	public static DataMasterFungsi toDomain(WebMasterFungsiUpdateRequest request, DataMasterFungsi domain) {
		return new DataMasterFungsiRecord(domain.id(),
		                                  domain.code(),
		                                  request.name(),
		                                  domain.isLocked(),
		                                  domain.isDeleted());
	}

}