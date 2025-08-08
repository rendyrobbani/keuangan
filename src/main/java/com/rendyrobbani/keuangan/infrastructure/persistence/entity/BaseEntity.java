package com.rendyrobbani.keuangan.infrastructure.persistence.entity;

import jakarta.persistence.MappedSuperclass;

import java.io.Serial;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

}