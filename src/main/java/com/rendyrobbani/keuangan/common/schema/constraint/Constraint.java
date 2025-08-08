package com.rendyrobbani.keuangan.common.schema.constraint;

public interface Constraint {

	String getName();

	String getValue();

	default String getNameAndValue() {
		return "constraint " + this.getName() + " " + this.getValue();
	}

}