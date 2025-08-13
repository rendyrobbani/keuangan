package com.rendyrobbani.keuangan.schema.user;

import com.rendyrobbani.keuangan.common.schema.table.Table;
import com.rendyrobbani.keuangan.common.schema.table.TableFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LogsUserTable {

	public static final String NAME = "logs_user";

	private static Table table;

	public static Table getTable() {
		if (table == null) table = TableFactory.createTableLog(NAME, DataUserTable.getTable());
		return table;
	}

}