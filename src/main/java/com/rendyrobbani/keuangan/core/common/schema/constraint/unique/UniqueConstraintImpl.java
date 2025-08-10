package com.rendyrobbani.keuangan.core.common.schema.constraint.unique;

import java.util.List;

record UniqueConstraintImpl(String name, List<String> columnNames) implements UniqueConstraint {

}