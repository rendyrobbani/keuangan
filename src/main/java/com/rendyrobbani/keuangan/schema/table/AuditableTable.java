package com.rendyrobbani.keuangan.schema.table;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.column.ColumnFactory;
import com.rendyrobbani.keuangan.common.schema.constraint.foreign.ForeignKeyConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.foreign.ForeignKeyConstraintFactory;
import com.rendyrobbani.keuangan.schema.table.user.DataUserTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AuditableTable {

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(ColumnFactory.createDateTime("created_at", false));
			columns.add(ColumnFactory.createNip("created_by", false));
			columns.add(ColumnFactory.createDateTime("updated_at", true));
			columns.add(ColumnFactory.createNip("updated_by", true));
			columns.add(ColumnFactory.createBoolean("is_deleted", false));
			columns.add(ColumnFactory.createDateTime("deleted_at", true));
			columns.add(ColumnFactory.createNip("deleted_by", true));
		}
		return columns;
	}

	private static List<ForeignKeyConstraint> foreignKeys;

	public static List<ForeignKeyConstraint> getForeignKeys(String tableName, Integer index) {
		if (foreignKeys == null) {
			foreignKeys = new ArrayList<>();
			foreignKeys.add(ForeignKeyConstraintFactory.create(
					tableName,
					foreignKeys.size() + index,
					"created_by",
					DataUserTable.NAME,
					"id"
			));
			foreignKeys.add(ForeignKeyConstraintFactory.create(
					tableName,
					foreignKeys.size() + index,
					"updated_by",
					DataUserTable.NAME,
					"id"
			));
			foreignKeys.add(ForeignKeyConstraintFactory.create(
					tableName,
					foreignKeys.size() + index,
					"deleted_by",
					DataUserTable.NAME,
					"id"
			));
		}
		return foreignKeys;
	}

}