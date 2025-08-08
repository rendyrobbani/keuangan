package com.rendyrobbani.keuangan.application.core.factory.master.urusan;

import com.rendyrobbani.keuangan.common.classification.urusan.UrusanClassification;
import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.domain.entity.master.urusan.DataMasterUrusan;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.urusan.DataMasterUrusanEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DataMasterUrusanFactory {

	public static DataMasterUrusan create(LocalDateTime createdAt, Nip createdBy, UrusanClassification classification) {
		return new DataMasterUrusanEntity(createdAt, createdBy, classification);
	}

}