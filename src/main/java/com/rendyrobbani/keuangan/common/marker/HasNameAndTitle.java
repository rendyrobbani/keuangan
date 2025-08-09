package com.rendyrobbani.keuangan.common.marker;

public interface HasNameAndTitle extends HasName {

	@Override
	default String name(boolean uppercase) {
		if (this.name() == null) return null;
		if (uppercase) return this.name().toUpperCase().replace("HJ.", "Hj.");
		return this.name();
	}

	String titlePrefix();

	String titleSuffix();

	default String getFullName(boolean uppercase) {
		if (this.name() == null) return null;
		var fullName = this.name(uppercase);
		if (this.titlePrefix() != null) fullName = this.titlePrefix() + " " + fullName;
		if (this.titleSuffix() != null) fullName = fullName + ", " + this.titleSuffix();
		return fullName;
	}

}