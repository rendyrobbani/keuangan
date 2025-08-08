package com.rendyrobbani.keuangan.common.marker;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDateTime;

public interface HasLockMutatorSupport extends HasLockMutator {

	void setLocked(boolean locked);

	void setLockedAt(LocalDateTime lockedAt);

	void setLockedBy(Nip lockedBy);

	void setUpdatedAt(LocalDateTime updatedAt);

	void setUpdatedBy(Nip updatedBy);

	@Override
	default void lock(LocalDateTime lockedAt, Nip lockedBy) {
		this.setLocked(true);
		this.setLockedAt(lockedAt);
		this.setLockedBy(lockedBy);
	}

	@Override
	default void unlock(LocalDateTime unlockedAt, Nip unlockedBy) {
		this.setLocked(false);
		this.setLockedAt(null);
		this.setLockedBy(null);

		this.setUpdatedAt(unlockedAt);
		this.setUpdatedBy(unlockedBy);
	}

}