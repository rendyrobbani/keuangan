package com.rendyrobbani.keuangan.common.schema.table;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.check.PrimaryConstraint;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
@SuppressWarnings("ClassCanBeRecord")
public final class TableImpl implements Table {

	private final String name;

	private final List<Column> columns;

	private final PrimaryConstraint primary;

	private final List<CheckConstraint> checks;

}