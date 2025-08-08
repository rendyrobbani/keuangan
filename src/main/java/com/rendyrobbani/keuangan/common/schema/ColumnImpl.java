package com.rendyrobbani.keuangan.common.schema;

import lombok.Getter;

@Getter
public final class ColumnImpl implements Column {

	private final String name;

	private final String size;

	private final ColumnType type;

	private final boolean isNullable;

	private final boolean isPrimaryKey;

	private final boolean isAutoIncrement;

	public ColumnImpl(String name, String size, ColumnType type, boolean isNullable, boolean isPrimaryKey, boolean isAutoIncrement) {
		this.name = name;
		this.size = size;
		this.type = type;
		this.isAutoIncrement = isAutoIncrement && type.getJavaType().equals(Long.class);
		this.isPrimaryKey = isPrimaryKey || this.isAutoIncrement;
		this.isNullable = isNullable && !this.isPrimaryKey;
	}

}