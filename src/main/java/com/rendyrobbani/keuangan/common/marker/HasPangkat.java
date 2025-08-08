package com.rendyrobbani.keuangan.common.marker;

import com.rendyrobbani.keuangan.common.vo.Pangkat;

public interface HasPangkat {

	Pangkat getPangkat();

	default String getPangkatValue() {
		if (this.getPangkat() == null) return null;
		return this.getPangkat().getValue();
	}

	default String getPangkatTitle() {
		if (this.getPangkat() == null) return null;
		return this.getPangkat().getTitle();
	}

}