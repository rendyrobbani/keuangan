package com.rendyrobbani.keuangan.common.schema.table;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.constraint.Constraint;

import java.util.List;

public interface Table {

	String getName();

	List<Column> getColumns();

	List<Constraint> getChecks();

}