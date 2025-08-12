package com.rendyrobbani.keuangan.infrastructure.persistence.repository.operation;

import com.rendyrobbani.keuangan.domain.model.entity.Base;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.SelectRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.repository.BaseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface SelectRepositoryOperation<ID, DOMAIN extends Base<ID>, ENTITY extends DOMAIN> extends SelectRepository<ID, DOMAIN>,
                                                                                                       BaseRepository<ID, DOMAIN, ENTITY> {

	@Override
	default List<DOMAIN> selectAll() {
		return new ArrayList<>(this.repository().findAll());
	}

	@Override
	default Optional<DOMAIN> selectById(ID id) {
		return Optional.ofNullable(this.repository().findById(id).orElse(null));
	}

}