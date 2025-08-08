package com.rendyrobbani.keuangan.infrastructure.persistence.repository.master.fungsi;

import com.rendyrobbani.keuangan.domain.entity.master.fungsi.DataMasterFungsi;
import com.rendyrobbani.keuangan.domain.repository.master.fungsi.DataMasterFungsiRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.fungsi.DataMasterFungsiEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.repository.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataMasterFungsiRepositoryImpl extends BaseRepositoryImpl<String, DataMasterFungsi, DataMasterFungsiEntity> implements DataMasterFungsiRepository {

	private final DataMasterFungsiJpaRepository repository;

	public DataMasterFungsiRepositoryImpl(DataMasterFungsiJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<DataMasterFungsiEntity, String> repository() {
		return repository;
	}

}