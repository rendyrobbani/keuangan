package com.rendyrobbani.keuangan.domain.model.shared;

import com.rendyrobbani.keuangan.common.util.name.NameUtil;

public interface HasNameAndTitles extends HasName {

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