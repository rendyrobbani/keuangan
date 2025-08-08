package com.rendyrobbani.keuangan.common.marker;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDateTime;

public interface HasLockMutator extends HasLockable {

	void lock(LocalDateTime lockedAt, Nip lockedBy);

	void unlock(LocalDateTime unlockedAt, Nip unlockedBy);

}