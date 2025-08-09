package com.rendyrobbani.keuangan.common.marker;

import com.rendyrobbani.keuangan.common.vo.Pangkat;

public interface HasPangkat {

	Pangkat pangkat();

	default String pangkatValue() {
		if (this.pangkat() == null) return null;
		return this.pangkat().value();
	}

	default String pangkatTitle() {
		if (this.pangkat() == null) return null;
		return this.pangkat().title();
	}

}