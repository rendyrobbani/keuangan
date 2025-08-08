package com.rendyrobbani.keuangan.common.marker;

public interface HasName {

	void setName(String name);

	String getName();

	default String getName(boolean uppercase) {
		if (this.getName() == null) return null;
		if (uppercase) return this.getName().toUpperCase();
		return this.getName();
	}

}