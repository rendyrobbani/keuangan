package com.rendyrobbani.keuangan.domain.entity.master.subfungsi;

import com.rendyrobbani.keuangan.common.marker.HasClassification;
import com.rendyrobbani.keuangan.domain.entity.master.fungsi.DataMasterFungsiReferencing;

public interface DataMasterSubfungsi extends HasClassification, DataMasterFungsiReferencing {

	String getId();

	@Override
	default String getCode() {
		return this.getId();
	}

	void setName(String name);

}