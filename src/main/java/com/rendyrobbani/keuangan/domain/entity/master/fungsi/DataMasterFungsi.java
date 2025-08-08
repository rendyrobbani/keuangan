package com.rendyrobbani.keuangan.domain.entity.master.fungsi;

import com.rendyrobbani.keuangan.common.marker.HasClassification;

public interface DataMasterFungsi extends HasClassification {

	String getId();

	@Override
	default String getCode() {
		return this.getId();
	}

	void setName(String name);

}