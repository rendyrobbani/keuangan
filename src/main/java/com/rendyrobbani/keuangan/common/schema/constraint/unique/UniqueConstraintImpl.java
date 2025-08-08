package com.rendyrobbani.keuangan.common.schema.constraint.unique;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@SuppressWarnings("ClassCanBeRecord")
final class UniqueConstraintImpl implements UniqueConstraint {

	private final String name;

	private final List<String> columnNames;

}