package com.rendyrobbani.keuangan.core.common.vo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum TypeOfASN {
	PNS(1, "PNS", "Pegawai Negeri Sipil"),
	P3K(2, "PPPK", "Pegawai Pemerintah dengan Perjanjian Kontrak");

	private final Integer value;

	private final String label;

	private final String title;

	public static TypeOfASN fromValue(Integer value) {
		if (value != null) for (var e : values()) if (e.value().equals(value)) return e;
		return null;
	}

	public static TypeOfASN fromValue(String value) {
		if (value.matches("^[12]$")) return fromValue(Integer.valueOf(value));
		return null;
	}
}