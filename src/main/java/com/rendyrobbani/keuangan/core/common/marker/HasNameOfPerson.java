package com.rendyrobbani.keuangan.core.common.marker;

import com.rendyrobbani.keuangan.core.common.util.name.NameUtil;

public interface HasNameOfPerson {

	String name();

	String titlePrefix();

	String titleSuffix();

	default String onlyName(boolean toUpperCase) {
		return NameUtil.onlyName(name(), toUpperCase);
	}

	default String fullName(boolean toUpperCase,
	                        String titlePrefix,
	                        String titleSuffix) {
		return NameUtil.fullName(name(), toUpperCase, titlePrefix, titleSuffix);
	}

}