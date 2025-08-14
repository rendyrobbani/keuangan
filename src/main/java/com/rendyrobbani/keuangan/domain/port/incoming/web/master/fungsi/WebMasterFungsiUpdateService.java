package com.rendyrobbani.keuangan.domain.port.incoming.web.master.fungsi;

import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiDetailResponse;
import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiUpdateRequest;

public interface WebMasterFungsiUpdateService {

	WebMasterFungsiDetailResponse update(String id, WebMasterFungsiUpdateRequest request);

}