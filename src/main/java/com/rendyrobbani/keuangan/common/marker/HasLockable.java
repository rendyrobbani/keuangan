package com.rendyrobbani.keuangan.common.marker;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDateTime;

public interface HasLockable extends HasAuditable {

	boolean isLocked();

	void setLocked(boolean locked);

	LocalDateTime getLockedAt();

	void setLockedAt(LocalDateTime lockedAt);

	Nip getLockedBy();

	void setLockedBy(Nip lockedBy);

	@Override
	default void create(LocalDateTime createdAt, Nip createdBy) {
		HasAuditable.super.create(createdAt, createdBy);
		this.setLocked(false);
	}

	default void lock(LocalDateTime lockedAt, Nip lockedBy) {
		this.setLocked(true);
		this.setLockedAt(lockedAt);
		this.setLockedBy(lockedBy);
	}

	default void unlock(LocalDateTime unlockedAt, Nip unlockedBy) {
		this.setLocked(false);
		this.setLockedAt(null);
		this.setLockedBy(null);

		this.update(unlockedAt, unlockedBy);
	}

}