package com.rendyrobbani.keuangan.infrastructure.persistence.repository;

import com.rendyrobbani.keuangan.infrastructure.persistence.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<ENTITY extends BaseEntity<DOMAIN, ID>, DOMAIN, ID> {

	JpaRepository<ENTITY, ID> repository();

}