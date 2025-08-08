package com.rendyrobbani.keuangan.domain.entity.master.fungsi;

public interface DataMasterFungsiReferencing {

	DataMasterFungsi getFungsi();

	default String getFungsiId() {
		if (this.getFungsi() == null) return null;
		return this.getFungsi().getId();
	}

	default String getFungsiCode() {
		if (this.getFungsi() == null) return null;
		return this.getFungsi().getCode();
	}

	default String getFungsiName() {
		if (this.getFungsi() == null) return null;
		return this.getFungsi().getName();
	}

	default String getFungsiName(boolean uppercase) {
		if (this.getFungsi() == null) return null;
		return this.getFungsi().getName(uppercase);
	}

}