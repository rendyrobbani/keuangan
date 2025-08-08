package com.rendyrobbani.keuangan.common.schema.constraint.foreign;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@SuppressWarnings("ClassCanBeRecord")
final class ForeignKeyConstraintImpl implements ForeignKeyConstraint {

	private final String name;

	private final List<String> columnNames;

	private final String referenceTableName;

	private final List<String> referenceColumnNames;

}