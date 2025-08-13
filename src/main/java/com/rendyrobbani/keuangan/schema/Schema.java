package com.rendyrobbani.keuangan.schema;

import com.rendyrobbani.keuangan.common.schema.table.Table;
import com.rendyrobbani.keuangan.schema.user.UserTable;

import java.util.ArrayList;
import java.util.List;

public class Schema {

	private static List<Table> tables;

	public static List<Table> getTables() {
		if (tables == null) {
			tables = new ArrayList<>();
			tables.add(UserTable.getTable());
		}
		return tables;
	}

}