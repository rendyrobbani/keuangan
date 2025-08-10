package com.rendyrobbani.keuangan.core.common.vo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Gender {
	LAKI_LAKI(1, "Laki-laki"),
	PEREMPUAN(2, "Perempuan");

	private final Integer value;

	private final String label;

	public static Gender fromValue(Integer value) {
		if (value != null) for (var e : values()) if (e.value().equals(value)) return e;
		return null;
	}

	public static Gender fromValue(String value) {
		if (value.matches("^[12]$")) return fromValue(Integer.valueOf(value));
		return null;
	}
}