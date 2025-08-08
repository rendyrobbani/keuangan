package com.rendyrobbani.keuangan.domain.entity.master.subfungsi;

public interface DataMasterSubfungsiReferencing {

	DataMasterSubfungsi getSubfungsi();

	default String getSubfungsiId() {
		if (this.getSubfungsi() == null) return null;
		return this.getSubfungsi().getId();
	}

	default String getSubfungsiCode() {
		if (this.getSubfungsi() == null) return null;
		return this.getSubfungsi().getCode();
	}

	default String getSubfungsiName() {
		if (this.getSubfungsi() == null) return null;
		return this.getSubfungsi().getName();
	}

	default String getSubfungsiName(boolean uppercase) {
		if (this.getSubfungsi() == null) return null;
		return this.getSubfungsi().getName(uppercase);
	}

}