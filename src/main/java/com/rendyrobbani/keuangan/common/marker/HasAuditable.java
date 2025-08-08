package com.rendyrobbani.keuangan.common.marker;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDateTime;

public interface HasAuditable {

	LocalDateTime getCreatedAt();

	void setCreatedAt(LocalDateTime createdAt);

	Nip getCreatedBy();

	void setCreatedBy(Nip createdBy);

	LocalDateTime getUpdatedAt();

	void setUpdatedAt(LocalDateTime updatedAt);

	Nip getUpdatedBy();

	void setUpdatedBy(Nip updatedBy);

	boolean isDeleted();

	void setDeleted(boolean deleted);

	LocalDateTime getDeletedAt();

	void setDeletedAt(LocalDateTime deletedAt);

	Nip getDeletedBy();

	void setDeletedBy(Nip deletedBy);

	default void create(LocalDateTime createdAt, Nip createdBy) {
		this.setCreatedAt(createdAt);
		this.setCreatedBy(createdBy);
		this.setDeleted(false);
	}

	default void update(LocalDateTime updatedAt, Nip updatedBy) {
		this.setUpdatedAt(updatedAt);
		this.setUpdatedBy(updatedBy);
	}

	default void delete(LocalDateTime deletedAt, Nip deletedBy) {
		this.setDeleted(true);
		this.setDeletedAt(deletedAt);
		this.setDeletedBy(deletedBy);
	}

	default void restore(LocalDateTime restoreAt, Nip restoredBy) {
		this.setDeleted(false);
		this.setDeletedAt(null);
		this.setDeletedBy(null);
		this.update(restoreAt, restoredBy);
	}

}