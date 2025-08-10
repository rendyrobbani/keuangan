package com.rendyrobbani.keuangan.data.support;

import com.rendyrobbani.keuangan.core.common.marker.audit.HasLockAccessor;
import com.rendyrobbani.keuangan.core.common.marker.audit.HasLockMutator;
import com.rendyrobbani.keuangan.core.common.vo.Nip;

import java.time.LocalDateTime;

public interface HasLockSupport extends HasLockAccessor,
                                        HasLockMutator,
                                        HasUpdateSupport {

	void isLocked(boolean isLocked);

	void lockedAt(LocalDateTime lockedAt);

	void lockedBy(Nip lockedBy);

	@Override
	default void lock(LocalDateTime lockedAt,
	                  Nip lockedBy) {
		isLocked(true);
		lockedAt(lockedAt);
		lockedBy(lockedBy);
	}

	@Override
	default void unlock(LocalDateTime unlockedAt,
	                    Nip unlockedBy) {
		isLocked(false);
		lockedAt(null);
		lockedBy(null);

		updatedAt(unlockedAt);
		updatedBy(unlockedBy);
	}

}