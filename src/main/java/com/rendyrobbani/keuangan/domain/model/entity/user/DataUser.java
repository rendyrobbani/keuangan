package com.rendyrobbani.keuangan.domain.model.entity.user;

import com.rendyrobbani.keuangan.domain.model.entity.Data;
import com.rendyrobbani.keuangan.domain.model.schema.user.User;

public interface DataUser extends User,
                                  Data<String> {

	@Override
	default String username() {
		return this.id();
	}

	boolean isLocked();

	boolean isDeleted();

}