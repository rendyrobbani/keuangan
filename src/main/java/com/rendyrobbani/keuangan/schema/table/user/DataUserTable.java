package com.rendyrobbani.keuangan.schema.table.user;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.column.ColumnFactory;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraintFactory;
import com.rendyrobbani.keuangan.common.schema.table.Table;
import com.rendyrobbani.keuangan.common.schema.table.TableFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataUserTable {

	public static final String NAME = "data_user";

	private static List<Column> columns;

	private static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(ColumnFactory.createNip("id", false, true));
			columns.addAll(BaseUserTable.getColumns());
		}
		return columns;
	}

	private static List<CheckConstraint> checks;

	public static List<CheckConstraint> getChecks() {
		if (checks == null) {
			checks = new ArrayList<>();
			checks.add(CheckConstraintFactory.columnIsNip(NAME, checks.size() + 1, "id"));
			checks.addAll(BaseUserTable.getChecks(NAME, checks.size() + 1));
		}
		return checks;
	}

	private static Table table;

	public static Table getTable() {
		if (table == null) table = TableFactory.createTable(NAME, getColumns(), getChecks());
		return table;
	}

}