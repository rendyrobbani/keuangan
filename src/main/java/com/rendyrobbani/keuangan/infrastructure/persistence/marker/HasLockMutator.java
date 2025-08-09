package com.rendyrobbani.keuangan.infrastructure.persistence.marker;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.domain.marker.HasLock;

import java.time.LocalDateTime;

public interface HasLockMutator<T> extends HasLock,
                                           HasLockAccessor,
                                           HasUpdateMutator<T> {

	T isLocked(boolean isLocked);

	T lockedAt(LocalDateTime lockedAt);

	T lockedBy(Nip lockedBy);

	@Override
	default void lock(LocalDateTime lockedAt, Nip lockedBy) {
		if (this.isLocked()) return;

		this.isLocked(true);
		this.lockedAt(lockedAt);
		this.lockedBy(lockedBy);
	}

	@Override
	default void unlock(LocalDateTime unlockedAt, Nip unlockedBy) {
		if (!this.isLocked()) return;

		this.isLocked(false);
		this.lockedAt(null);
		this.lockedBy(null);

		this.updatedAt(unlockedAt);
		this.updatedBy(unlockedBy);
	}

}