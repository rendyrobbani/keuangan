package com.rendyrobbani.keuangan.schema.table.master.urusan;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.column.ColumnFactory;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraintFactory;
import com.rendyrobbani.keuangan.common.schema.constraint.foreign.ForeignKeyConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.foreign.ForeignKeyConstraintFactory;
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
public final class SIPDMasterUrusanTable {

	public static final String NAME = "sipd_master_urusan";

	private static List<Column> columns;

	private static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(ColumnFactory.createBigInt("id", false, true));
			columns.add(ColumnFactory.createUrusanCode("code", false));
			columns.add(ColumnFactory.createVarChar("name", false));
			columns.addAll(LockableTable.getColumns());
			columns.addAll(AuditableTable.getColumns());

			columns.add(ColumnFactory.createUrusanCode("urusan_id", false));
		}
		return columns;
	}

	private static List<ForeignKeyConstraint> foreignKeys;

	public static List<ForeignKeyConstraint> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new ArrayList<>();
			foreignKeys.addAll(LockableTable.getForeignKeys(NAME, foreignKeys.size() + 1));
			foreignKeys.addAll(AuditableTable.getForeignKeys(NAME, foreignKeys.size() + 1));

			foreignKeys.add(ForeignKeyConstraintFactory.create(NAME, foreignKeys.size() + 1, "urusan_id", DataMasterUrusanTable.NAME, "id"));
		}
		return foreignKeys;
	}

	private static Table table;

	public static Table getTable() {
		if (table == null) table = TableFactory.createTable(NAME, getColumns(), null, getForeignKeys(), null);
		return table;
	}

}