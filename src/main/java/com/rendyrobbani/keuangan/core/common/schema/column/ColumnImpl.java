package com.rendyrobbani.keuangan.core.common.schema.column;

record ColumnImpl(String name,
                  String size,
                  ColumnType type,
                  boolean isNullable,
                  boolean isPrimaryKey,
                  boolean isAutoIncrement) implements Column {

}