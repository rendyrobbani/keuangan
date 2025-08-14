package com.rendyrobbani.keuangan.domain.port.incoming.web.master.fungsi;

import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiCreateRequest;
import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiDetailResponse;

public interface WebMasterFungsiCreateService {

	WebMasterFungsiDetailResponse create(WebMasterFungsiCreateRequest request);

}