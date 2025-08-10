package com.rendyrobbani.keuangan.core.common.marker.audit;

import com.rendyrobbani.keuangan.core.common.vo.Nip;

import java.time.LocalDateTime;

public interface HasUpdateAccessor {

	LocalDateTime updatedAt();

	Nip updatedBy();

}