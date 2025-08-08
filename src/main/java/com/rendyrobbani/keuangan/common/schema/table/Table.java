package com.rendyrobbani.keuangan.common.schema.table;

import com.rendyrobbani.keuangan.common.schema.constraint.Constraint;

import java.util.List;

public interface Table {

	String getName();

	String getColumns();

	List<Constraint> getChecks();

}