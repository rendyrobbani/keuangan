package com.rendyrobbani.keuangan.domain.model.schema.master.codes.fungsi;

public interface MasterFungsiReference {

	MasterFungsi fungsi();

	default String fungsiCode() {
		if (fungsi() == null) return null;
		return fungsi().code();
	}

	default String fungsiName() {
		if (fungsi() == null) return null;
		return fungsi().name();
	}

	default String fungsiName(boolean toUpperCase) {
		if (fungsi() == null) return null;
		return fungsi().name(toUpperCase);
	}

}