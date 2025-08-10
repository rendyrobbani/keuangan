package com.rendyrobbani.keuangan.data.support;

import com.rendyrobbani.keuangan.core.common.marker.audit.HasDeleteAccessor;
import com.rendyrobbani.keuangan.core.common.marker.audit.HasDeleteMutator;
import com.rendyrobbani.keuangan.core.common.vo.Nip;

import java.time.LocalDateTime;

public interface HasDeleteSupport extends HasDeleteAccessor,
                                          HasDeleteMutator,
                                          HasUpdateSupport {

	void isDeleted(boolean isDeleted);

	void deletedAt(LocalDateTime deletedAt);

	void deletedBy(Nip deletedBy);

	@Override
	default void delete(LocalDateTime deletedAt,
	                    Nip deletedBy) {
		isDeleted(true);
		deletedAt(deletedAt);
		deletedBy(deletedBy);
	}

	@Override
	default void restore(LocalDateTime restoredAt,
	                     Nip restoredBy) {
		isDeleted(false);
		deletedAt(null);
		deletedBy(null);

		updatedAt(restoredAt);
		updatedBy(restoredBy);
	}

}