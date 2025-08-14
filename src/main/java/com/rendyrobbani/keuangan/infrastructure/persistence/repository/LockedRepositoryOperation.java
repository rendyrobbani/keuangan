package com.rendyrobbani.keuangan.infrastructure.persistence.repository;

import com.rendyrobbani.keuangan.domain.model.entity.Lock;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.LockedRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.LockEntity;

import java.time.LocalDateTime;

public interface LockedRepositoryOperation<ENTITY extends LockEntity<DOMAIN, ID>, DOMAIN extends Lock<ID>, ID> extends BaseRepository<ENTITY, DOMAIN, ID>,
                                                                                                                       LockedRepository<DOMAIN, ID> {

	@Override
	default DOMAIN lock(DOMAIN domain, LocalDateTime lockedAt, Nip lockedBy) {
		if (domain.id() == null) throw new RuntimeException("Entity id cannot be null");
		ENTITY entity = this.repository().findById(domain.id()).orElseThrow(() -> new RuntimeException("Entity with id " + domain.id() + " not found"));
		if (entity.isLocked()) return entity.toDomain();
		entity.sync(domain);
		entity.lock(lockedAt, lockedBy);
		this.repository().save(entity);
		return entity.toDomain();
	}

	@Override
	default DOMAIN unlock(DOMAIN domain, LocalDateTime unlockedAt, Nip unlockedBy) {
		if (domain.id() == null) throw new RuntimeException("Entity id cannot be null");
		ENTITY entity = this.repository().findById(domain.id()).orElseThrow(() -> new RuntimeException("Entity with id " + domain.id() + " not found"));
		if (!entity.isLocked()) return entity.toDomain();
		entity.sync(domain);
		entity.unlock(unlockedAt, unlockedBy);
		this.repository().save(entity);
		return entity.toDomain();
	}

}