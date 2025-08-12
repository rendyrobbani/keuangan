package com.rendyrobbani.keuangan.infrastructure.persistence.mapper;

import com.rendyrobbani.keuangan.domain.model.vo.Nip;

import java.time.LocalDateTime;

public interface BaseMapper<ENTITY extends DOMAIN, DOMAIN> {

	ENTITY create(DOMAIN domain, LocalDateTime createdAt, Nip createdBy);

}