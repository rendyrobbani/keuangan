package com.rendyrobbani.keuangan.infrastructure.persistence.repository.master.bidang;

import com.rendyrobbani.keuangan.domain.entity.master.bidang.DataMasterBidang;
import com.rendyrobbani.keuangan.domain.repository.master.bidang.DataMasterBidangRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.bidang.DataMasterBidangEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.repository.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataMasterBidangRepositoryImpl extends BaseRepositoryImpl<String, DataMasterBidang, DataMasterBidangEntity> implements DataMasterBidangRepository {

	private final DataMasterBidangJpaRepository repository;

	public DataMasterBidangRepositoryImpl(DataMasterBidangJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<DataMasterBidangEntity, String> repository() {
		return repository;
	}

}