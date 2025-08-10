package com.rendyrobbani.keuangan.core.domain.master.classification.fungsi;

public interface ReferenceMasterFungsi {

	DataMasterFungsi fungsi();

	String fungsiId();

	default String fungsiCode() {
		if (fungsi() == null) return null;
		return fungsi().code();
	}

	default String fungsiName() {
		if (fungsi() == null) return null;
		return fungsi().name();
	}

}