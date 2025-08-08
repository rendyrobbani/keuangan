package com.rendyrobbani.keuangan.common.schema.constraint.primary;

import com.rendyrobbani.keuangan.common.schema.constraint.Constraint;

import java.util.List;

public interface PrimaryConstraint extends Constraint {

	@Override
	default String getName() {
		return "PRIMARY";
	}

	List<String> getColumnNames();

	@Override
	default String getValue() {
		return "primary key (" + String.join(", ", this.getColumnNames()) + ")";
	}

}