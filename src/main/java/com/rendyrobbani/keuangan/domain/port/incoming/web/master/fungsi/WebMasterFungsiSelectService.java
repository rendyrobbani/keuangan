package com.rendyrobbani.keuangan.domain.port.incoming.web.master.fungsi;

import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiDetailResponse;
import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiSelectResponse;

import java.util.List;

public interface WebMasterFungsiSelectService {

	List<WebMasterFungsiSelectResponse> selectAll();

	WebMasterFungsiDetailResponse selectById(String id);

}