package com.rendyrobbani.keuangan.data.support;

import com.rendyrobbani.keuangan.core.common.marker.audit.HasCreateAccessor;
import com.rendyrobbani.keuangan.core.common.marker.audit.HasCreateMutator;
import com.rendyrobbani.keuangan.core.common.vo.Nip;

import java.time.LocalDateTime;

public interface HasCreateSupport extends HasCreateAccessor,
                                          HasCreateMutator {

	void createdAt(LocalDateTime createdAt);

	void createdBy(Nip createdBy);

	@Override
	default void create(LocalDateTime createdAt,
	                    Nip createdBy) {
		createdAt(createdAt);
		createdBy(createdBy);
	}

}