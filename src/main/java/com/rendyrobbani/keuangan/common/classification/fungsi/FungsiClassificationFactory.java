package com.rendyrobbani.keuangan.common.classification.fungsi;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FungsiClassificationFactory {

	public static FungsiClassification classify(String code) {
		if (code == null) return null;
		if (!code.matches(FungsiClassification.REGEX)) return null;
		return new FungsiClassificationImpl(code);
	}

}