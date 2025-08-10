package com.rendyrobbani.keuangan.infrastructure.persistence.entity;

import java.io.Serial;
import java.io.Serializable;

public abstract class AbstractEntity<ID> implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	protected abstract ID id();

}