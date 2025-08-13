package com.rendyrobbani.keuangan.infrastructure.persistence.repository.operation;

import com.rendyrobbani.keuangan.domain.model.entity.Base;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.CreateRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.BaseEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.repository.BaseRepository;

import java.time.LocalDateTime;

public interface CreateRepositoryOperation<ENTITY extends BaseEntity<DOMAIN, ID>, DOMAIN extends Base<ID>, ID> extends BaseRepository<ENTITY, DOMAIN, ID>,
                                                                                                                       CreateRepository<DOMAIN, ID> {

	ENTITY instance();

	@Override
	default DOMAIN create(DOMAIN domain, LocalDateTime createdAt, Nip createdBy) {
		if (domain.id() != null && this.repository().existsById(domain.id())) throw new RuntimeException("Entity with id " + domain.id() + " already exists");
		ENTITY entity = this.instance();
		entity.sync(domain);
		entity.create(createdAt, createdBy);
		this.repository().save(entity);
		return entity.toDomain();
	}

}