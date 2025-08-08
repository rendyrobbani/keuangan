package com.rendyrobbani.keuangan.schema.table.user;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.column.ColumnFactory;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraintFactory;
import com.rendyrobbani.keuangan.schema.table.AuditableTable;
import com.rendyrobbani.keuangan.schema.table.LockableTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BaseUserTable {

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(ColumnFactory.createPangkat("pangkat", false));
			columns.add(ColumnFactory.createVarChar("name", false));
			columns.add(ColumnFactory.createVarChar("title_prefix", false));
			columns.add(ColumnFactory.createVarChar("title_suffix", false));
			columns.add(ColumnFactory.createVarChar("password", false));
			columns.add(ColumnFactory.createDateOnly("birth_date", false));
			columns.add(ColumnFactory.createDateOnly("start_date", true));
			columns.add(ColumnFactory.createGender("gender", false));
			columns.add(ColumnFactory.createTinyInt("number", false));

			columns.addAll(LockableTable.getColumns());
			columns.addAll(AuditableTable.getColumns());
		}
		return columns;
	}

	private static List<CheckConstraint> checks;

	public static List<CheckConstraint> getChecks(String tableName, Integer index) {
		if (checks == null) {
			checks = new ArrayList<>();
			checks.add(CheckConstraintFactory.columnPangkat(tableName, checks.size() + index, "pangkat"));
			checks.add(CheckConstraintFactory.columnGender(tableName, checks.size() + index, "gender"));
			checks.add(CheckConstraintFactory.columnBetween(tableName, checks.size() + index, "number", 1, 999));
		}
		return checks;
	}

}