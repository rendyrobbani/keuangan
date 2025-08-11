package com.rendyrobbani.keuangan.infrastructure.persistence.mapper;

import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.DataEntity;

import java.time.LocalDateTime;

public interface DataMapper<ID, DOMAIN, ENTITY extends DataEntity<ID, DOMAIN>> {

	ENTITY create(DOMAIN domain, LocalDateTime createdAt, Nip createdBy);

	ENTITY update(DOMAIN domain, LocalDateTime updatedAt, Nip updatedBy);

}