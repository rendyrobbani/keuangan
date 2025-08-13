package com.rendyrobbani.keuangan.infrastructure.persistence.entity;

import com.rendyrobbani.keuangan.domain.model.entity.Data;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;

import java.time.LocalDateTime;

public interface DataEntity<DOMAIN, ID> extends BaseEntity<DOMAIN, ID>,
                                                Data<ID> {

	void updatedAt(LocalDateTime updatedAt);

	void updatedBy(Nip updatedBy);

	void isDeleted(boolean isDeleted);

	void deletedAt(LocalDateTime deletedAt);

	void deletedBy(Nip deletedBy);

	default void update(LocalDateTime updatedAt, Nip updatedBy) {
		this.updatedAt(updatedAt);
		this.updatedBy(updatedBy);
	}

	default void delete(LocalDateTime deletedAt, Nip deletedBy) {
		this.isDeleted(true);
		this.deletedAt(deletedAt);
		this.deletedBy(deletedBy);
	}

	default void restore(LocalDateTime restoredAt, Nip restoredBy) {
		this.isDeleted(false);
		this.deletedAt(null);
		this.deletedBy(null);
		this.updatedAt(restoredAt);
		this.updatedBy(restoredBy);
	}

}