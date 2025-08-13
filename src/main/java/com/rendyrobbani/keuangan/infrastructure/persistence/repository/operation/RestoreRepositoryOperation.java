package com.rendyrobbani.keuangan.infrastructure.persistence.repository.operation;

import com.rendyrobbani.keuangan.domain.model.entity.Data;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.RestoreRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.DataEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.repository.BaseRepository;

import java.time.LocalDateTime;

public interface RestoreRepositoryOperation<ENTITY extends DataEntity<DOMAIN, ID>, DOMAIN extends Data<ID>, ID> extends BaseRepository<ENTITY, DOMAIN, ID>,
                                                                                                                        RestoreRepository<DOMAIN, ID> {

	@Override
	default DOMAIN restore(DOMAIN domain, LocalDateTime restoredAt, Nip restoredBy) {
		if (domain.id() == null) throw new RuntimeException("Entity id cannot be null");
		ENTITY entity = this.repository().findById(domain.id()).orElseThrow(() -> new RuntimeException("Entity with id " + domain.id() + " not found"));
		if (!entity.isDeleted()) return entity.toDomain();
		entity.sync(domain);
		entity.restore(restoredAt, restoredBy);
		this.repository().save(entity);
		return entity.toDomain();
	}

}