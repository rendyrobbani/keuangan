package com.rendyrobbani.keuangan.core.common.classification.fungsi;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SubfungsiClassificationFactory {

	public static SubfungsiClassification classify(String code) {
		if (code != null && code.matches(SubfungsiClassification.PATTERN)) {
			var codes = code.split("\\.");
			return new SubfungsiClassificationRecord(codes[0], codes[1]);
		}
		return null;
	}

}