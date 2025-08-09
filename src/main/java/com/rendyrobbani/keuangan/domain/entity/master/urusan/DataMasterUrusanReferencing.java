package com.rendyrobbani.keuangan.domain.entity.master.urusan;

public interface DataMasterUrusanReferencing {

	DataMasterUrusan getUrusan();

	default String getUrusanId() {
		if (this.getUrusan() == null) return null;
		return this.getUrusan().getId();
	}

	default String getUrusanCode() {
		if (this.getUrusan() == null) return null;
		return this.getUrusan().getCode();
	}

	default String getUrusanName() {
		if (this.getUrusan() == null) return null;
		return this.getUrusan().name();
	}

	default String getUrusanName(boolean uppercase) {
		if (this.getUrusan() == null) return null;
		return this.getUrusan().name(uppercase);
	}

}