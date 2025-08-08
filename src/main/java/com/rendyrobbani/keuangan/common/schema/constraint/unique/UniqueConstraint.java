package com.rendyrobbani.keuangan.common.schema.constraint.unique;

import com.rendyrobbani.keuangan.common.schema.constraint.Constraint;

import java.util.List;

public interface UniqueConstraint extends Constraint {

	List<String> getColumnNames();

	@Override
	default String getValue() {
		return "Unique key (" + String.join(", ", this.getColumnNames()) + ")";
	}

}