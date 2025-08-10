package com.rendyrobbani.keuangan.core.common.marker;

public interface HasName {

	String name();

	default String name(boolean toUpperCase) {
		if (name() == null) return null;
		if (toUpperCase) return name().toUpperCase();
		return name();
	}

}