package com.rendyrobbani.keuangan.core.common.schema.constraint.primary;

import java.util.List;

record PrimaryConstraintImpl(List<String> columnNames) implements PrimaryConstraint {

}