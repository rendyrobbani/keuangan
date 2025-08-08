package com.rendyrobbani.keuangan.common.marker;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDateTime;

public interface HasAuditMutator extends HasAuditable {

	void create(LocalDateTime createdAt, Nip createdBy);

	void update(LocalDateTime updatedAt, Nip updatedBy);

	void delete(LocalDateTime deletedAt, Nip deletedBy);

	void restore(LocalDateTime restoreAt, Nip restoredBy);

}