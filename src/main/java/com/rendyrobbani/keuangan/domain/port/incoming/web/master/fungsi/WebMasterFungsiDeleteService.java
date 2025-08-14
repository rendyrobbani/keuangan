package com.rendyrobbani.keuangan.domain.port.incoming.web.master.fungsi;

import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiDetailResponse;

public interface WebMasterFungsiDeleteService {

	WebMasterFungsiDetailResponse delete(String id);

	WebMasterFungsiDetailResponse restore(String id);

}