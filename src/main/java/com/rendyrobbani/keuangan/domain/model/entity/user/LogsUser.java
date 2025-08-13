package com.rendyrobbani.keuangan.domain.model.entity.user;

import com.rendyrobbani.keuangan.domain.model.entity.Logs;
import com.rendyrobbani.keuangan.domain.model.schema.user.User;

public interface LogsUser extends User,
                                  Logs<String> {

	@Override
	default String username() {
		return this.subjectId();
	}

	boolean isLocked();

	boolean isDeleted();

}