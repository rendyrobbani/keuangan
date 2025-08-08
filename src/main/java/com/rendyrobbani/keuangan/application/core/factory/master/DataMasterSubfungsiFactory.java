package com.rendyrobbani.keuangan.application.core.factory.master;

import com.rendyrobbani.keuangan.common.classification.subfungsi.SubfungsiClassification;
import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.domain.entity.master.subfungsi.DataMasterSubfungsi;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.subfungsi.DataMasterSubfungsiEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DataMasterSubfungsiFactory {

	public static DataMasterSubfungsi create(LocalDateTime createdAt, Nip createdBy, SubfungsiClassification classification) {
		return new DataMasterSubfungsiEntity(createdAt, createdBy, classification);
	}

}