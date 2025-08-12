package com.rendyrobbani.keuangan.infrastructure.persistence.repository;

import com.rendyrobbani.keuangan.domain.model.entity.Base;
import com.rendyrobbani.keuangan.infrastructure.persistence.mapper.BaseMapper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<ID, DOMAIN extends Base<ID>, ENTITY extends DOMAIN> {

	JpaRepository<ENTITY, ID> repository();

	BaseMapper<DOMAIN, ENTITY> mapper();

}