package com.rendyrobbani.keuangan.schema.table.user;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.column.ColumnFactory;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraintFactory;
import com.rendyrobbani.keuangan.common.schema.constraint.foreign.ForeignKeyConstraint;
import com.rendyrobbani.keuangan.common.schema.table.Table;
import com.rendyrobbani.keuangan.common.schema.table.TableFactory;
import com.rendyrobbani.keuangan.schema.table.AuditableTable;
import com.rendyrobbani.keuangan.schema.table.LockableTable;
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
			columns.add(ColumnFactory.createPangkat("pangkat", false));
			columns.add(ColumnFactory.createVarChar("name", false));
			columns.add(ColumnFactory.createVarChar("title_prefix", false));
			columns.add(ColumnFactory.createVarChar("title_suffix", false));
			columns.add(ColumnFactory.createVarChar("password", false));
			columns.add(ColumnFactory.createDateOnly("birth_date", false));
			columns.add(ColumnFactory.createDateOnly("start_date", true));
			columns.add(ColumnFactory.createGender("gender", false));
			columns.add(ColumnFactory.createTinyInt("number", false));
			columns.add(ColumnFactory.createBoolean("is_pns", false));
			columns.add(ColumnFactory.createBoolean("is_p3k", false));
			columns.addAll(LockableTable.getColumns());
			columns.addAll(AuditableTable.getColumns());
		}
		return columns;
	}

	private static List<CheckConstraint> checks;

	private static List<CheckConstraint> getChecks() {
		if (checks == null) {
			checks = new ArrayList<>();
			checks.add(CheckConstraintFactory.columnIsNip(NAME, checks.size() + 1, "id"));
			checks.add(CheckConstraintFactory.columnPangkat(NAME, checks.size() + 1, "pangkat"));
			checks.add(CheckConstraintFactory.columnGender(NAME, checks.size() + 1, "gender"));
			checks.add(CheckConstraintFactory.columnBetween(NAME, checks.size() + 1, "number", 1, 999));
		}
		return checks;
	}

	private static List<ForeignKeyConstraint> foreignKeys;

	public static List<ForeignKeyConstraint> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new ArrayList<>();
			foreignKeys.addAll(LockableTable.getForeignKeys(NAME, foreignKeys.size() + 1));
			foreignKeys.addAll(AuditableTable.getForeignKeys(NAME, foreignKeys.size() + 1));
		}
		return foreignKeys;
	}

	private static Table table;

	public static Table getTable() {
		if (table == null) table = TableFactory.createTable(NAME, getColumns(), getChecks(), getForeignKeys());
		return table;
	}

}