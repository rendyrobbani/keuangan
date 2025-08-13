package com.rendyrobbani.keuangan.domain.model.entity.user;

import com.rendyrobbani.keuangan.domain.model.entity.Lock;
import com.rendyrobbani.keuangan.domain.model.schema.user.User;

public interface DataUser extends User,
                                  Lock<String> {

	@Override
	default String username() {
		return this.id();
	}

	default LogsUser toLog() {
		return new LogsUserRecord(null,
		                          this.id(),
		                          this.nip(),
		                          this.pangkat(),
		                          this.name(),
		                          this.titlePrefix(),
		                          this.titleSuffix(),
		                          this.password(),
		                          this.dateOfBirth(),
		                          this.dateOfStart(),
		                          this.gender(),
		                          this.number(),
		                          this.isPNS(),
		                          this.isP3K(),
		                          this.isLocked(),
		                          this.isDeleted());
	}

}