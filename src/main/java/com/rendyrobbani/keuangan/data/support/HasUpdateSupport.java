package com.rendyrobbani.keuangan.data.support;

import com.rendyrobbani.keuangan.core.common.marker.audit.HasUpdateAccessor;
import com.rendyrobbani.keuangan.core.common.marker.audit.HasUpdateMutator;
import com.rendyrobbani.keuangan.core.common.vo.Nip;

import java.time.LocalDateTime;

public interface HasUpdateSupport extends HasUpdateAccessor,
                                          HasUpdateMutator {

	void updatedAt(LocalDateTime updatedAt);

	void updatedBy(Nip updatedBy);

	@Override
	default void update(LocalDateTime updatedAt,
	                    Nip updatedBy) {
		updatedAt(updatedAt);
		updatedBy(updatedBy);
	}

}