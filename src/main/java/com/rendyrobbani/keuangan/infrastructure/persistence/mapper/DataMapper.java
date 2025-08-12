package com.rendyrobbani.keuangan.infrastructure.persistence.mapper;

import com.rendyrobbani.keuangan.domain.model.vo.Nip;

import java.time.LocalDateTime;

public interface DataMapper<ENTITY extends DOMAIN, DOMAIN> extends BaseMapper<ENTITY, DOMAIN> {

	ENTITY update(DOMAIN domain, LocalDateTime updatedAt, Nip updatedBy, ENTITY entity);

}