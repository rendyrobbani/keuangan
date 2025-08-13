package com.rendyrobbani.keuangan.infrastructure.persistence.entity;

import com.rendyrobbani.keuangan.domain.model.entity.Lock;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;

import java.time.LocalDateTime;

public interface LockEntity<DOMAIN, ID> extends DataEntity<DOMAIN, ID>,
                                                Lock<ID> {

	void isLocked(boolean isLocked);

	void lockedAt(LocalDateTime lockedAt);

	void lockedBy(Nip lockedBy);

	default void lock(LocalDateTime lockedAt, Nip lockedBy) {
		this.isLocked(true);
		this.lockedAt(lockedAt);
		this.lockedBy(lockedBy);
	}

	default void unlock(LocalDateTime unlockedAt, Nip unlockedBy) {
		this.isLocked(false);
		this.lockedAt(null);
		this.lockedBy(null);
		this.updatedAt(unlockedAt);
		this.updatedBy(unlockedBy);
	}

	@Override
	default void delete(LocalDateTime deletedAt, Nip deletedBy) {
		this.lock(deletedAt, deletedBy);
		DataEntity.super.delete(deletedAt, deletedBy);
	}

}