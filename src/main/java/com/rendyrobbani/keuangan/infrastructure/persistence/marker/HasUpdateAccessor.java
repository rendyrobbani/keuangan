package com.rendyrobbani.keuangan.infrastructure.persistence.marker;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDateTime;

public interface HasUpdateAccessor {

	LocalDateTime updatedAt(LocalDateTime updatedAt);

	Nip updatedBy(Nip updatedBy);

}