package com.rendyrobbani.keuangan.infrastructure.persistence.entity;

import com.rendyrobbani.keuangan.domain.model.entity.Base;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;

import java.time.LocalDateTime;

public interface BaseEntity<DOMAIN, ID> extends Base<ID> {

	DOMAIN toDomain();

	void sync(DOMAIN domain);

	void createdAt(LocalDateTime createdAt);

	void createdBy(Nip createdBy);

	default void create(LocalDateTime createdAt, Nip createdBy) {
		this.sync(toDomain());
		this.createdAt(createdAt);
		this.createdBy(createdBy);
	}

}