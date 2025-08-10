package com.rendyrobbani.keuangan.core.common.schema.table;

import com.rendyrobbani.keuangan.core.common.schema.column.Column;
import com.rendyrobbani.keuangan.core.common.schema.constraint.check.CheckConstraint;
import com.rendyrobbani.keuangan.core.common.schema.constraint.foreign.ForeignKeyConstraint;
import com.rendyrobbani.keuangan.core.common.schema.constraint.primary.PrimaryConstraintFactory;
import com.rendyrobbani.keuangan.core.common.schema.constraint.unique.UniqueConstraint;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TableFactory {

	public static Table createTable(String name,
	                                List<Column> columns,
	                                List<CheckConstraint> checks,
	                                List<ForeignKeyConstraint> foreignKeys,
	                                List<UniqueConstraint> uniques) {
		return new TableImpl(
				name,
				columns,
				PrimaryConstraintFactory.create(columns.stream().filter(Column::isPrimaryKey).map(Column::name).toList()),
				checks,
				foreignKeys,
				uniques
		);
	}

}