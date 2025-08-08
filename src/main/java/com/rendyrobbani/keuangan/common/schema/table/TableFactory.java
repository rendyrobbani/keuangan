package com.rendyrobbani.keuangan.common.schema.table;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.check.PrimaryConstraintImpl;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TableFactory {

	public static Table createTable(String name, List<Column> columns, List<CheckConstraint> checks) {
		return new TableImpl(name, columns, new PrimaryConstraintImpl(columns.stream().filter(Column::isPrimaryKey).toList()), checks);
	}

}