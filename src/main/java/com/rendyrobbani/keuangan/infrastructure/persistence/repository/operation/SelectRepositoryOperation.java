package com.rendyrobbani.keuangan.infrastructure.persistence.repository.operation;

import com.rendyrobbani.keuangan.domain.model.entity.Base;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.SelectRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.BaseEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface SelectRepositoryOperation<ID, DOMAIN extends Base<ID>, ENTITY extends BaseEntity<ID, DOMAIN>> extends SelectRepository<ID, DOMAIN>,
                                                                                                                       BaseRepository<ID, DOMAIN, ENTITY> {

	@Override
	default List<DOMAIN> selectAll() {
		return this.repository().findAll().stream().map(BaseEntity::toDomain).toList();
	}

	@Override
	default Optional<DOMAIN> selectById(ID id) {
		return this.repository().findById(id).map(BaseEntity::toDomain);
	}

}