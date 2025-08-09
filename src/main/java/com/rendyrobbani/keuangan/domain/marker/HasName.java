package com.rendyrobbani.keuangan.domain.marker;

public interface HasName {

	String name();

	default String name(boolean uppercase) {
		if (this.name() == null) return null;
		if (uppercase) return this.name().toUpperCase();
		return this.name();
	}

}