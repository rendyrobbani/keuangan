package com.rendyrobbani.keuangan.schema.user;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.column.ColumnFactory;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraintFactory;
import com.rendyrobbani.keuangan.common.schema.constraint.foreign.ForeignKeyConstraint;
import com.rendyrobbani.keuangan.common.schema.table.Table;
import com.rendyrobbani.keuangan.common.schema.table.TableFactory;
import com.rendyrobbani.keuangan.schema.base.DataTable;
import com.rendyrobbani.keuangan.schema.base.LockTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserTable {

	public static final String NAME = "data_user";

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(ColumnFactory.createNip("id", false, true));
			columns.add(ColumnFactory.createPangkat("pangkat", false));
			columns.add(ColumnFactory.createVarChar("name", false));
			columns.add(ColumnFactory.createVarChar("title_prefix", true));
			columns.add(ColumnFactory.createVarChar("title_suffix", true));
			columns.add(ColumnFactory.createVarChar("password", false));
			columns.add(ColumnFactory.createDateOnly("date_of_birth", false));
			columns.add(ColumnFactory.createDateOnly("date_of_start", true));
			columns.add(ColumnFactory.createGender("gender", false));
			columns.add(ColumnFactory.createSmallInt("number", false));
			columns.add(ColumnFactory.createBoolean("is_pns", false));
			columns.add(ColumnFactory.createBoolean("is_p3k", false));
			columns.addAll(LockTable.getColumns());
			columns.addAll(DataTable.getColumns());
		}
		return columns;
	}

	private static List<CheckConstraint> checks;

	public static List<CheckConstraint> getChecks() {
		if (checks == null) {
			checks = new ArrayList<>();
			checks.add(CheckConstraintFactory.columnIsNip(NAME, checks.size() + 1, "id"));
			checks.add(CheckConstraintFactory.columnIsPangkat(NAME, checks.size() + 1, "pangkat"));
			checks.add(CheckConstraintFactory.columnIsGender(NAME, checks.size() + 1, "gender"));
			checks.add(CheckConstraintFactory.columnsNotEqual(NAME, checks.size() + 1, "is_pns", "is_p3k"));
		}
		return checks;
	}

	private static List<ForeignKeyConstraint> foreignKeys;

	public static List<ForeignKeyConstraint> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new ArrayList<>();
			foreignKeys.addAll(DataTable.getForeignKeys(NAME, foreignKeys.size() + 1));
		}
		return foreignKeys;
	}

	private static Table table;

	public static Table getTable() {
		if (table == null) table = TableFactory.createTable(NAME, getColumns(), getChecks(), getForeignKeys(), null);
		return table;
	}

}