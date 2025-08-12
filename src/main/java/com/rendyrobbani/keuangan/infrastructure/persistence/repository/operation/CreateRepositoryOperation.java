package com.rendyrobbani.keuangan.infrastructure.persistence.repository.operation;

import com.rendyrobbani.keuangan.domain.model.entity.Base;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.CreateRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.repository.BaseRepository;

import java.time.LocalDateTime;

public interface CreateRepositoryOperation<ENTITY extends DOMAIN, DOMAIN extends Base<ID>, ID> extends CreateRepository<DOMAIN>,
                                                                                                       BaseRepository<ENTITY, DOMAIN, ID> {

	@Override
	default DOMAIN create(DOMAIN domain, LocalDateTime createdAt, Nip createdBy) {
		if (domain.id() != null && this.repository().existsById(domain.id())) throw new RuntimeException("Entity with id " + domain.id() + " already exists");
		return this.repository().save(this.mapper().create(domain, createdAt, createdBy));
	}

}