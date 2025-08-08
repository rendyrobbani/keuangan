package com.rendyrobbani.keuangan.common.schema.table;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.foreign.ForeignKeyConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.primary.PrimaryConstraintFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TableFactory {

	public static Table createTable(String name, List<Column> columns, List<CheckConstraint> checks, List<ForeignKeyConstraint> foreignKeys) {
		return new TableImpl(
				name,
				columns,
				PrimaryConstraintFactory.create(columns.stream().filter(Column::isPrimaryKey).map(Column::getName).toList()),
				checks,
				foreignKeys
		);
	}

}