package com.rendyrobbani.keuangan.core.common.marker.audit;

import com.rendyrobbani.keuangan.core.common.vo.Nip;

import java.time.LocalDateTime;

public interface HasLockMutator {

	void lock(LocalDateTime lockedAt,
	          Nip lockedBy);

	void unlock(LocalDateTime unlockedAt,
	            Nip unlockedBy);

}