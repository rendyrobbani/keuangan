package com.rendyrobbani.keuangan.common.schema.constraint.check;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
@SuppressWarnings("ClassCanBeRecord")
public final class PrimaryConstraintImpl implements PrimaryConstraint {

	private final List<Column> columns;

}