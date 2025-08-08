package com.rendyrobbani.keuangan.application.core.factory.master.bidang;

import com.rendyrobbani.keuangan.common.classification.bidang.BidangClassification;
import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.domain.entity.master.bidang.DataMasterBidang;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.bidang.DataMasterBidangEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DataMasterBidangFactory {

	public static DataMasterBidang create(LocalDateTime createdAt, Nip createdBy, BidangClassification classification) {
		return new DataMasterBidangEntity(createdAt, createdBy, classification);
	}

}