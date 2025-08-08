package com.rendyrobbani.keuangan.schema.table.master.bidang;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.column.ColumnFactory;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraintFactory;
import com.rendyrobbani.keuangan.common.schema.constraint.foreign.ForeignKeyConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.foreign.ForeignKeyConstraintFactory;
import com.rendyrobbani.keuangan.common.schema.constraint.unique.UniqueConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.unique.UniqueConstraintFactory;
import com.rendyrobbani.keuangan.common.schema.table.Table;
import com.rendyrobbani.keuangan.common.schema.table.TableFactory;
import com.rendyrobbani.keuangan.schema.table.AuditableTable;
import com.rendyrobbani.keuangan.schema.table.LockableTable;
import com.rendyrobbani.keuangan.schema.table.master.urusan.DataMasterUrusanTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataMasterBidangTable {

	public static final String NAME = "data_master_bidang";

	private static List<Column> columns;

	private static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(ColumnFactory.createBidangCode("id", false, true));
			columns.add(ColumnFactory.createBidangCode("code", false));
			columns.add(ColumnFactory.createVarChar("name", false));
			columns.addAll(LockableTable.getColumns());
			columns.addAll(AuditableTable.getColumns());

			columns.add(ColumnFactory.createUrusanCode("urusan_id", false));
		}
		return columns;
	}

	private static List<CheckConstraint> checks;

	private static List<CheckConstraint> getChecks() {
		if (checks == null) {
			checks = new ArrayList<>();
			checks.add(CheckConstraintFactory.columnEquals(NAME, checks.size() + 1, "id", "replace(code, 'X', '0')"));
			checks.add(CheckConstraintFactory.columnsStartsWith(NAME, checks.size() + 1, "id", "urusan_id"));
		}
		return checks;
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

	private static List<UniqueConstraint> uniques;

	public static List<UniqueConstraint> getUniques() {
		if (uniques == null) {
			uniques = new ArrayList<>();
			uniques.add(UniqueConstraintFactory.create(NAME, uniques.size() + 1, List.of("urusan_id", "id")));
		}
		return uniques;
	}

	private static Table table;

	public static Table getTable() {
		if (table == null) table = TableFactory.createTable(NAME, getColumns(), getChecks(), getForeignKeys(), getUniques());
		return table;
	}

}