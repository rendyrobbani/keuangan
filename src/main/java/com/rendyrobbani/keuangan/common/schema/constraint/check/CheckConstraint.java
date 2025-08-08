package com.rendyrobbani.keuangan.common.schema.constraint.check;

import com.rendyrobbani.keuangan.common.schema.constraint.Constraint;

public interface CheckConstraint extends Constraint {

	String getLogic();

	@Override
	default String getValue() {
		return "check (" + this.getLogic() + ")";
	}

}