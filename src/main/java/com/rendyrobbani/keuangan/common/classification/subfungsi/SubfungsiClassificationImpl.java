package com.rendyrobbani.keuangan.common.classification.subfungsi;

import com.rendyrobbani.keuangan.common.classification.fungsi.FungsiClassification;
import lombok.Getter;

@Getter
class SubfungsiClassificationImpl implements FungsiClassification, SubfungsiClassification {

	private final String fungsiCode;

	private final String subfungsiCode;

	SubfungsiClassificationImpl(String[] codes) {
		this.fungsiCode = codes[0];
		this.subfungsiCode = codes[1];
	}

}