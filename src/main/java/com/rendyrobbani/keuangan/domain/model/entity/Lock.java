package com.rendyrobbani.keuangan.domain.model.entity;

import com.rendyrobbani.keuangan.domain.model.vo.Nip;

import java.time.LocalDateTime;

public interface Lock<ID> extends Data<ID> {

	boolean isLocked();

	void lock(LocalDateTime lockedAt, Nip lockedBy);

	void unlock(LocalDateTime unlockedAt, Nip unlockedBy);

}