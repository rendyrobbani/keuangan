package com.rendyrobbani.keuangan.infrastructure.persistence.repository;

import com.rendyrobbani.keuangan.domain.model.entity.Base;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.SelectRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface SelectRepositoryOperation<ENTITY extends BaseEntity<DOMAIN, ID>, DOMAIN extends Base<ID>, ID> extends BaseRepository<ENTITY, DOMAIN, ID>,
                                                                                                                       SelectRepository<DOMAIN, ID> {

	@Override
	default List<DOMAIN> selectAll() {
		return this.repository().findAll().stream().map(BaseEntity::toDomain).toList();
	}

	@Override
	default Optional<DOMAIN> selectById(ID id) {
		return this.repository().findById(id).map(BaseEntity::toDomain);
	}

}