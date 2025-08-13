package com.rendyrobbani.keuangan.common.classification.urusan;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UrusanClassificationFactory {

	public static UrusanClassification classify(String code) {
		if (code == null) return null;
		if (!code.matches(UrusanClassification.REGEX)) return null;
		return new UrusanClassificationImpl(code);
	}

}