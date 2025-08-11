package com.rendyrobbani.keuangan.domain.model.entity.user;

import com.rendyrobbani.keuangan.domain.model.entity.Base;
import com.rendyrobbani.keuangan.domain.model.schema.user.User;

public interface DataUser extends Base<String>,
                                  User {

	@Override
	default String username() {
		return this.id();
	}

	boolean isLocked();

	boolean isDeleted();

}