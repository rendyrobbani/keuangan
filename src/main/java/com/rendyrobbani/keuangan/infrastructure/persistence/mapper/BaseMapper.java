package com.rendyrobbani.keuangan.infrastructure.persistence.mapper;

import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.BaseEntity;

import java.time.LocalDateTime;

public interface BaseMapper<ID, DOMAIN, ENTITY extends BaseEntity<ID, DOMAIN>> {

	ENTITY create(DOMAIN domain, LocalDateTime createdAt, Nip createdBy);

	ENTITY update(DOMAIN domain, LocalDateTime updatedAt, Nip updatedBy);

}