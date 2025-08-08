package com.rendyrobbani.keuangan.common.schema.constraint.check;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@SuppressWarnings("ClassCanBeRecord")
final class CheckConstraintImpl implements CheckConstraint {

	private final String name;

	private final String logic;

}