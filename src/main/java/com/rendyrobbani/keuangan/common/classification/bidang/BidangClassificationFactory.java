package com.rendyrobbani.keuangan.common.classification.bidang;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BidangClassificationFactory {

	public static BidangClassification classify(String code) {
		if (code == null) return null;
		if (!code.matches(BidangClassification.REGEX)) return null;
		var codes = code.split("\\.");
		return new BidangClassificationImpl(codes[0], codes[1]);
	}

}