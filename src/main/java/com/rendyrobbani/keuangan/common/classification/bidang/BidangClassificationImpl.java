package com.rendyrobbani.keuangan.common.classification.bidang;

import com.rendyrobbani.keuangan.common.classification.urusan.UrusanClassification;
import lombok.Getter;

@Getter
class BidangClassificationImpl implements UrusanClassification, BidangClassification {

	private final String urusanCode;

	private final String bidangCode;

	BidangClassificationImpl(String[] codes) {
		this.urusanCode = codes[0];
		this.bidangCode = codes[1];
	}

}