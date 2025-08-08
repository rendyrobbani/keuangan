package com.rendyrobbani.keuangan.common.schema.constraint.primary;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@SuppressWarnings("ClassCanBeRecord")
final class PrimaryConstraintImpl implements PrimaryConstraint {

	private final List<String> columnNames;

}