package com.rendyrobbani.keuangan.schema;

import com.rendyrobbani.keuangan.common.schema.table.Table;
import com.rendyrobbani.keuangan.common.util.number.NumberUtil;
import com.rendyrobbani.keuangan.schema.table.master.fungsi.DataMasterFungsiTable;
import com.rendyrobbani.keuangan.schema.table.master.subfungsi.DataMasterSubfungsiTable;
import com.rendyrobbani.keuangan.schema.table.user.DataUserTable;
import com.rendyrobbani.keuangan.schema.table.user.LogsUserTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class KeuanganSchema {

	private static List<Table> getUserTables() {
		var tables = new ArrayList<Table>();
		tables.add(DataUserTable.getTable());
		tables.add(LogsUserTable.getTable());
		return tables;
	}

	private static List<Table> getMasterTables() {
		var tables = new ArrayList<Table>();
		tables.add(DataMasterFungsiTable.getTable());
		tables.add(DataMasterSubfungsiTable.getTable());
		return tables;
	}

	private static List<Table> tables;

	public static List<Table> getTables() {
		if (tables == null) {
			tables = new ArrayList<>();
			tables.addAll(getUserTables());
			tables.addAll(getMasterTables());
		}
		return tables;
	}

	public static void writeDDL(File location) {
		try {
			var index = 0;
			for (var table : getTables()) {
				index++;

				var fileName = NumberUtil.lpadZero(index, 3) + "-" + table.getName() + ".sql";
				var file = new File(location, fileName);
				try (var output = new FileOutputStream(file)) {
					output.write(table.getDeleteDDL().getBytes(StandardCharsets.UTF_8));
					output.write(System.lineSeparator().repeat(2).getBytes(StandardCharsets.UTF_8));
					output.write(table.getCreateDDL().getBytes(StandardCharsets.UTF_8));
				}
			}
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

}