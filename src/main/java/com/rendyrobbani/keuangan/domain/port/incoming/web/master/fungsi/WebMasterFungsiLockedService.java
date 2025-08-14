package com.rendyrobbani.keuangan.domain.port.incoming.web.master.fungsi;

import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiDetailResponse;

public interface WebMasterFungsiLockedService {

	WebMasterFungsiDetailResponse lock(String id);

	WebMasterFungsiDetailResponse unlock(String id);

}