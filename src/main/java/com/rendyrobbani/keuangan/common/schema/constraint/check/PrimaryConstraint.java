package com.rendyrobbani.keuangan.common.schema.constraint.check;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.constraint.Constraint;

import java.util.List;

public interface PrimaryConstraint extends Constraint {

	@Override
	default String getName() {
		return "PRIMARY";
	}

	List<Column> getColumns();

	@Override
	default String getValue() {
		return "primary key (" + String.join(", ", this.getColumns().stream().map(Column::getName).toList()) + ")";
	}

}