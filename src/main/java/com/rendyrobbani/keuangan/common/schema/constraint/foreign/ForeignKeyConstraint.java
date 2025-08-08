package com.rendyrobbani.keuangan.common.schema.constraint.foreign;

import com.rendyrobbani.keuangan.common.schema.constraint.Constraint;

import java.util.List;

public interface ForeignKeyConstraint extends Constraint {

	List<String> getColumnNames();

	String getReferenceTableName();

	List<String> getReferenceColumnNames();

	@Override
	default String getValue() {
		return String.join(" ",
				"foreign key",
				"(" + String.join(", ", getColumnNames()) + ")",
				"references",
				getReferenceTableName(),
				"(" + String.join(", ", getReferenceColumnNames()) + ")"
		);
	}

}