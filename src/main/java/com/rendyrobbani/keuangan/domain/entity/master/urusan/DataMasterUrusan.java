package com.rendyrobbani.keuangan.domain.entity.master.urusan;

import com.rendyrobbani.keuangan.common.marker.HasClassification;

public interface DataMasterUrusan extends HasClassification {

	String getId();

	@Override
	default String getCode() {
		return this.getId();
	}

	void setName(String name);

}