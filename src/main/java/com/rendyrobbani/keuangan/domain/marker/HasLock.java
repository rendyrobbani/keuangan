package com.rendyrobbani.keuangan.domain.marker;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDateTime;

public interface HasLock {

	void lock(LocalDateTime lockedAt, Nip lockedBy);

	void unlock(LocalDateTime unlockedAt, Nip unlockedBy);

}