package com.rendyrobbani.keuangan.domain.entity.master.urusan;

import com.rendyrobbani.keuangan.common.marker.HasClassification;
import com.rendyrobbani.keuangan.domain.entity.master.DataMaster;

public interface DataMasterUrusan extends DataMaster<String>, HasClassification {

	@Override
	default String getCode() {
		return this.getId();
	}

	void setName(String name);

}