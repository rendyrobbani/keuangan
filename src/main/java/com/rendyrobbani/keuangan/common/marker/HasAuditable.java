package com.rendyrobbani.keuangan.common.marker;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDateTime;

public interface HasAuditable {

	LocalDateTime getCreatedAt();

	Nip getCreatedBy();

	LocalDateTime getUpdatedAt();

	Nip getUpdatedBy();

	boolean isDeleted();

	LocalDateTime getDeletedAt();

	Nip getDeletedBy();

}