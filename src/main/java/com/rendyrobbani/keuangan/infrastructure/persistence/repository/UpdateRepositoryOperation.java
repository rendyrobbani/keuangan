package com.rendyrobbani.keuangan.infrastructure.persistence.repository;

import com.rendyrobbani.keuangan.domain.model.entity.Data;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.UpdateRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.DataEntity;

import java.time.LocalDateTime;

public interface UpdateRepositoryOperation<ENTITY extends DataEntity<DOMAIN, ID>, DOMAIN extends Data<ID>, ID> extends BaseRepository<ENTITY, DOMAIN, ID>,
                                                                                                                       UpdateRepository<DOMAIN, ID> {

	@Override
	default DOMAIN update(DOMAIN domain, LocalDateTime updatedAt, Nip updatedBy) {
		if (domain.id() == null) throw new RuntimeException("Entity id cannot be null");
		ENTITY entity = this.repository().findById(domain.id()).orElseThrow(() -> new RuntimeException("Entity with id " + domain.id() + " not found"));
		entity.sync(domain);
		entity.update(updatedAt, updatedBy);
		this.repository().save(entity);
		return entity.toDomain();
	}

}