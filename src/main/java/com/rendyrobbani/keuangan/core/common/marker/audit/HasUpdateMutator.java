package com.rendyrobbani.keuangan.core.common.marker.audit;

import com.rendyrobbani.keuangan.core.common.vo.Nip;

import java.time.LocalDateTime;

public interface HasUpdateMutator {

	void update(LocalDateTime updatedAt,
	            Nip updatedBy);

}