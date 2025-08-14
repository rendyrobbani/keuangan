package com.rendyrobbani.keuangan.infrastructure.persistence.entity;

import com.rendyrobbani.keuangan.domain.model.entity.Logs;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;

import java.time.LocalDateTime;

public interface LogsEntity<DOMAIN, SUBJECTID> extends Logs<SUBJECTID>,
                                                       BaseEntity<DOMAIN, Long> {

	void loggedAt(LocalDateTime loggedAt);

	void loggedBy(Nip loggedBy);

	@Override
	default void createdAt(LocalDateTime createdAt) {
		this.loggedAt(createdAt);
	}

	@Override
	default void createdBy(Nip createdBy) {
		this.loggedBy(createdBy);
	}

}