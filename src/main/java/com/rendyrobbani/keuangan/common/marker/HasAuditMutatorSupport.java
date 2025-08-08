package com.rendyrobbani.keuangan.common.marker;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDateTime;

public interface HasAuditMutatorSupport extends HasAuditMutator {

	void setCreatedAt(LocalDateTime createdAt);

	void setCreatedBy(Nip createdBy);

	void setUpdatedAt(LocalDateTime updatedAt);

	void setUpdatedBy(Nip updatedBy);

	void setDeleted(boolean deleted);

	void setDeletedAt(LocalDateTime deletedAt);

	void setDeletedBy(Nip deletedBy);

	@Override
	default void create(LocalDateTime createdAt, Nip createdBy) {
		this.setCreatedAt(createdAt);
		this.setCreatedBy(createdBy);
		this.setDeleted(false);
	}

	@Override
	default void update(LocalDateTime updatedAt, Nip updatedBy) {
		this.setUpdatedAt(updatedAt);
		this.setUpdatedBy(updatedBy);
	}

	@Override
	default void delete(LocalDateTime deletedAt, Nip deletedBy) {
		this.setDeleted(true);
		this.setDeletedAt(deletedAt);
		this.setDeletedBy(deletedBy);
	}

	@Override
	default void restore(LocalDateTime restoreAt, Nip restoredBy) {
		this.setDeleted(false);
		this.setDeletedAt(null);
		this.setDeletedBy(null);

		this.setUpdatedAt(restoreAt);
		this.setUpdatedBy(restoredBy);
	}

}