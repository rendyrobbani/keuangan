package com.rendyrobbani.keuangan.domain.entity.master.bidang;

public interface DataMasterBidangReferencing {

	DataMasterBidang getBidang();

	default String getBidangId() {
		if (this.getBidang() == null) return null;
		return this.getBidang().getId();
	}

	default String getBidangCode() {
		if (this.getBidang() == null) return null;
		return this.getBidang().getCode();
	}

	default String getBidangName() {
		if (this.getBidang() == null) return null;
		return this.getBidang().getName();
	}

	default String getBidangName(boolean uppercase) {
		if (this.getBidang() == null) return null;
		return this.getBidang().getName(uppercase);
	}

}