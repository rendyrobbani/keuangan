package com.rendyrobbani.keuangan.infrastructure.persistence.marker;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDateTime;

public interface HasUpdateMutator<T> {

	T updatedAt(LocalDateTime updatedAt);

	T updatedBy(Nip updatedBy);

	default void update(LocalDateTime updatedAt, Nip updatedBy) {
		this.updatedAt(updatedAt);
		this.updatedBy(updatedBy);
	}

}