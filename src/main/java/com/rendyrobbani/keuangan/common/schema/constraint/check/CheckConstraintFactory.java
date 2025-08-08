package com.rendyrobbani.keuangan.common.schema.constraint.check;

import com.rendyrobbani.keuangan.common.schema.constraint.Constraint;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CheckConstraintFactory {

	public static Constraint createConstraint(String value, String logic) {
		return new CheckConstraintImpl(value, logic);
	}

}