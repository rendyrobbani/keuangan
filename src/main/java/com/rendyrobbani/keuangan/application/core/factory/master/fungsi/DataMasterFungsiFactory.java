package com.rendyrobbani.keuangan.application.core.factory.master.fungsi;

import com.rendyrobbani.keuangan.common.classification.fungsi.FungsiClassification;
import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.domain.entity.master.fungsi.DataMasterFungsi;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.fungsi.DataMasterFungsiEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DataMasterFungsiFactory {

	public static DataMasterFungsi create(LocalDateTime createdAt, Nip createdBy, FungsiClassification classification) {
		return new DataMasterFungsiEntity(createdAt, createdBy, classification);
	}

}