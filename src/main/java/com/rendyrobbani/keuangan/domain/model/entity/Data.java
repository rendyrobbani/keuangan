package com.rendyrobbani.keuangan.domain.model.entity;

import com.rendyrobbani.keuangan.domain.model.vo.Nip;

import java.time.LocalDateTime;

public interface Data<ID> extends Base<ID> {

	boolean isDeleted();

	void update(LocalDateTime updatedAt, Nip updatedBy);

	void delete(LocalDateTime deletedAt, Nip deletedBy);

	void restore(LocalDateTime restoredAt, Nip restoredBy);

}