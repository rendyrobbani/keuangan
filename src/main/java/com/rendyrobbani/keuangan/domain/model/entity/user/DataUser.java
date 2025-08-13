package com.rendyrobbani.keuangan.domain.model.entity.user;

import com.rendyrobbani.keuangan.domain.model.entity.Lock;
import com.rendyrobbani.keuangan.domain.model.schema.user.User;

public interface DataUser extends User,
                                  Lock<String> {

	@Override
	default String username() {
		return this.id();
	}

}