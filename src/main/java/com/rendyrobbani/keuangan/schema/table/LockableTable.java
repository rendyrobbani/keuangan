package com.rendyrobbani.keuangan.schema.table;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.column.ColumnFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LockableTable {

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(ColumnFactory.createBoolean("is_locked", false));
			columns.add(ColumnFactory.createDateTime("locked_at", true));
			columns.add(ColumnFactory.createNip("locked_by", true));
		}
		return columns;
	}

}