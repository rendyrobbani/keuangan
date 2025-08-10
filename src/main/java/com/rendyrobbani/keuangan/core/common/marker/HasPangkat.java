package com.rendyrobbani.keuangan.core.common.marker;

import com.rendyrobbani.keuangan.core.common.vo.Pangkat;

public interface HasPangkat {

	Pangkat pangkat();

	default String pangkatValue() {
		if (pangkat() == null) return null;
		return pangkat().value();
	}

	default String pangkatTitle() {
		if (pangkat() == null) return null;
		return pangkat().title();
	}

}