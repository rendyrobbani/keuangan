package com.rendyrobbani.keuangan.schema.table.user;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.column.ColumnFactory;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.foreign.ForeignKeyConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.foreign.ForeignKeyConstraintFactory;
import com.rendyrobbani.keuangan.common.schema.table.Table;
import com.rendyrobbani.keuangan.common.schema.table.TableFactory;
import com.rendyrobbani.keuangan.schema.table.AuditableTable;
import com.rendyrobbani.keuangan.schema.table.LockableTable;
import com.rendyrobbani.keuangan.schema.table.LoggableTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LogsUserTable {

	public static final String NAME = "logs_user";

	private static List<Column> columns;

	private static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(ColumnFactory.createBigInt("id", false, true, true));
			columns.addAll(DataUserTable.getTable().getColumns().stream().filter(c -> !c.isPrimaryKey()).toList());

			columns.addAll(LoggableTable.getColumns());
			columns.add(ColumnFactory.copyOf("subject_id", DataUserTable.getTable().findColumn("id"), false));
		}
		return columns;
	}

	private static List<CheckConstraint> checks;

	private static List<CheckConstraint> getChecks() {
		if (checks == null) {
			checks = new ArrayList<>();
			checks.addAll(BaseUserTable.getChecks(NAME, checks.size() + 1));
		}
		return checks;
	}

	private static List<ForeignKeyConstraint> foreignKeys;

	public static List<ForeignKeyConstraint> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new ArrayList<>();
			foreignKeys.addAll(LockableTable.getForeignKeys(NAME, foreignKeys.size() + 1));
			foreignKeys.addAll(AuditableTable.getForeignKeys(NAME, foreignKeys.size() + 1));

			foreignKeys.add(ForeignKeyConstraintFactory.create(NAME, foreignKeys.size() + 1, "subject_id", DataUserTable.NAME, "id"));

			foreignKeys.addAll(LoggableTable.getForeignKeys(NAME, foreignKeys.size() + 1));
		}
		return foreignKeys;
	}

	private static Table table;

	public static Table getTable() {
		if (table == null) table = TableFactory.createTable(NAME, getColumns(), getChecks(), getForeignKeys());
		return table;
	}

}