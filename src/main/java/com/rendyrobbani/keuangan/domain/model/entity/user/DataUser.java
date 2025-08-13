package com.rendyrobbani.keuangan.domain.model.entity.user;

import com.rendyrobbani.keuangan.domain.model.entity.Data;
import com.rendyrobbani.keuangan.domain.model.schema.user.User;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;

import java.time.LocalDateTime;

public interface DataUser extends User,
                                  Data<String> {

	@Override
	default String username() {
		return this.id();
	}

	boolean isLocked();

	void lock(LocalDateTime lockedAt, Nip lockedBy);

	void unlock(LocalDateTime unlockedAt, Nip unlockedBy);

}