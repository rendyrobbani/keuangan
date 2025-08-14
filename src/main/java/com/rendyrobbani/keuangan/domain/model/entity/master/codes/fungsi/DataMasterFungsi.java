package com.rendyrobbani.keuangan.domain.model.entity.master.codes.fungsi;

import com.rendyrobbani.keuangan.domain.model.entity.master.codes.DataMasterCodes;

public interface DataMasterFungsi extends DataMasterCodes {

	@Override
	default String code() {
		return this.id();
	}

}