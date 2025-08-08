package com.rendyrobbani.keuangan.domain.entity.master.bidang;

import com.rendyrobbani.keuangan.common.marker.HasClassification;
import com.rendyrobbani.keuangan.domain.entity.master.urusan.DataMasterUrusanReferencing;

public interface DataMasterBidang extends HasClassification, DataMasterUrusanReferencing {

	String getId();

	@Override
	default String getCode() {
		return this.getId();
	}

	void setName(String name);

}