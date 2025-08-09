package com.rendyrobbani.keuangan.common.marker;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDateTime;

public interface HasAuditable {

	LocalDateTime createdAt();

	Nip createdBy();

	LocalDateTime updatedAt();

	Nip updatedBy();

	boolean isDeleted();

	LocalDateTime deletedAt();

	Nip deletedBy();

}