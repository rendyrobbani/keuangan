package com.rendyrobbani.keuangan.common.schema.table;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.check.PrimaryConstraint;

import java.util.ArrayList;
import java.util.List;

public interface Table {

	String ENGINE = "innodb";
	String CHARSET = "utf8mb4";
	String COLLATE = "utf8mb4_unicode_ci";

	String getName();

	List<Column> getColumns();

	PrimaryConstraint getPrimary();

	List<CheckConstraint> getChecks();

	default Column findColumn(String name) {
		return this.getColumns().stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
	}

	default String getDeleteDDL(boolean useIfExists) {
		return String.join(" ", "drop table" + (useIfExists ? " if exists" : ""), this.getName()) + ";";
	}

	default String getDeleteDDL() {
		return this.getDeleteDDL(true);
	}

	default String getCreateDDL(boolean useOrReplace) {
		List<String> ddl = new ArrayList<>();
		ddl.add("create " + (useOrReplace ? "or replace " : "") + "table " + this.getName() + " (");
		int maxName = 0;
		int maxType = 0;
		for (var column : this.getColumns()) {
			maxName = Math.max(maxName, column.getName().length());
			maxType = Math.max(maxType, column.getTypeAndSize().length());
		}
		for (var column : this.getColumns()) {
			var name = column.getName() + " ".repeat(maxName - column.getName().length());
			var type = column.getTypeAndSize() + " ".repeat(maxType - column.getTypeAndSize().length());
			var attr = column.isNullable() ? "null" : "not null";
			if (column.isAutoIncrement()) attr += " auto_increment";
			ddl.add("\t" + String.join(" ", name, type, attr) + ",");
		}
		if (getChecks() != null) for (var check : this.getChecks()) ddl.add("\t" + check.getNameAndValue() + ",");
		ddl.add("\t" + this.getPrimary().getValue());
		ddl.add(") engine = " + ENGINE);
		ddl.add("  charset = " + CHARSET);
		ddl.add("  collate = " + COLLATE + ";");
		return String.join(System.lineSeparator(), ddl);
	}

}