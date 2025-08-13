package com.rendyrobbani.keuangan.infrastructure.persistence.repository.operation;

import com.rendyrobbani.keuangan.domain.model.entity.Data;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.DeleteRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.DataEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.repository.BaseRepository;

import java.time.LocalDateTime;

public interface DeleteRepositoryOperation<ENTITY extends DataEntity<DOMAIN, ID>, DOMAIN extends Data<ID>, ID> extends BaseRepository<ENTITY, DOMAIN, ID>,
                                                                                                                       DeleteRepository<DOMAIN, ID> {

	@Override
	default DOMAIN delete(DOMAIN domain, LocalDateTime deletedAt, Nip deletedBy) {
		if (domain.id() == null) throw new RuntimeException("Entity id cannot be null");
		ENTITY entity = this.repository().findById(domain.id()).orElseThrow(() -> new RuntimeException("Entity with id " + domain.id() + " not found"));
		if (entity.isDeleted()) return entity.toDomain();
		entity.sync(domain);
		entity.delete(deletedAt, deletedBy);
		this.repository().save(entity);
		return entity.toDomain();
	}

}