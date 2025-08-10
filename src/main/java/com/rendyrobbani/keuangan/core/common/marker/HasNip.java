package com.rendyrobbani.keuangan.core.common.marker;

import com.rendyrobbani.keuangan.core.common.vo.Nip;

public interface HasNip {

	Nip nip();

	default String simpleNip() {
		if (nip() == null) return null;
		return nip().simple();
	}

	default String styledNip() {
		if (nip() == null) return null;
		return nip().styled();
	}

}