package com.rendyrobbani.keuangan.core.common.schema.table;

import com.rendyrobbani.keuangan.core.common.schema.column.Column;
import com.rendyrobbani.keuangan.core.common.schema.constraint.check.CheckConstraint;
import com.rendyrobbani.keuangan.core.common.schema.constraint.foreign.ForeignKeyConstraint;
import com.rendyrobbani.keuangan.core.common.schema.constraint.primary.PrimaryConstraint;
import com.rendyrobbani.keuangan.core.common.schema.constraint.unique.UniqueConstraint;

import java.util.List;

record TableImpl(String name, List<Column> columns, PrimaryConstraint primary, List<CheckConstraint> checks, List<ForeignKeyConstraint> foreignKeys, List<UniqueConstraint> uniques) implements Table {

}