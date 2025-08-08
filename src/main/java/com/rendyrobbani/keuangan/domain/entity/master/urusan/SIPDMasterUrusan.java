package com.rendyrobbani.keuangan.domain.entity.master.urusan;

import com.rendyrobbani.keuangan.common.marker.HasClassification;

public interface SIPDMasterUrusan extends HasClassification, DataMasterUrusanReferencing {

	Long getId();

	void setName(String name);

}