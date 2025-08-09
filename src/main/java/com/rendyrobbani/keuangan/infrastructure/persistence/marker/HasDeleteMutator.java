package com.rendyrobbani.keuangan.infrastructure.persistence.marker;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.domain.marker.HasDelete;

import java.time.LocalDateTime;

public interface HasDeleteMutator<T> extends HasDelete,
                                             HasUpdateMutator<T> {

	T isDeleted(boolean isDeleted);

	T deletedAt(LocalDateTime deletedAt);

	T deletedBy(Nip deletedBy);

	default void delete(LocalDateTime deletedAt, Nip deletedBy) {
		this.isDeleted(true);
		this.deletedAt(deletedAt);
		this.deletedBy(deletedBy);
	}

	default void restore(LocalDateTime restoreAt, Nip restoredBy) {
		this.isDeleted(false);
		this.deletedAt(null);
		this.deletedBy(null);

		this.update(restoreAt, restoredBy);
	}

}