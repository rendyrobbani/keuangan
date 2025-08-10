package com.rendyrobbani.keuangan.core.common.classification.fungsi;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FungsiClassificationFactory {

	public static FungsiClassification classify(String code) {
		if (code != null && code.matches(FungsiClassification.PATTERN)) return new FungsiClassificationRecord(code);
		return null;
	}

}