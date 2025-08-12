package com.rendyrobbani.keuangan.infrastructure.persistence.mapper;

import com.rendyrobbani.keuangan.domain.model.vo.Nip;

import java.time.LocalDateTime;

public interface DataMapper<DOMAIN, ENTITY extends DOMAIN> extends BaseMapper<DOMAIN, ENTITY> {

	ENTITY update(DOMAIN domain, LocalDateTime updatedAt, Nip updatedBy, ENTITY entity);

}