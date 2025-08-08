package com.rendyrobbani.keuangan.common.schema.constraint.check;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@SuppressWarnings("ClassCanBeRecord")
public final class CheckConstraintImpl implements CheckConstraint {

	private final String name;

	private final String logic;

}