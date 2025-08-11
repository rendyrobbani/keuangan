package com.rendyrobbani.keuangan.infrastructure.persistence.entity;

import com.rendyrobbani.keuangan.domain.model.entity.Base;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;

import java.time.LocalDateTime;

public interface BaseEntity<ID, DOMAIN> extends Base<ID> {

	DOMAIN toDomain();

	BaseEntity<ID, DOMAIN> create(LocalDateTime createdAt, Nip createdBy);

}