package com.rendyrobbani.keuangan.schema;

import com.rendyrobbani.keuangan.common.schema.table.Table;
import com.rendyrobbani.keuangan.schema.user.DataUserTable;
import com.rendyrobbani.keuangan.schema.user.LogsUserTable;

import java.util.ArrayList;
import java.util.List;

public class Schema {

	private static List<Table> tables;

	public static List<Table> getTables() {
		if (tables == null) {
			tables = new ArrayList<>();
			tables.add(DataUserTable.getTable());
			tables.add(LogsUserTable.getTable());
		}
		return tables;
	}

}