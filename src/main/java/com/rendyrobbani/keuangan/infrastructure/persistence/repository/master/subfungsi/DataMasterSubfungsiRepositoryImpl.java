package com.rendyrobbani.keuangan.infrastructure.persistence.repository.master.subfungsi;

import com.rendyrobbani.keuangan.domain.entity.master.subfungsi.DataMasterSubfungsi;
import com.rendyrobbani.keuangan.domain.repository.master.subfungsi.DataMasterSubfungsiRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.subfungsi.DataMasterSubfungsiEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.repository.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataMasterSubfungsiRepositoryImpl extends BaseRepositoryImpl<String, DataMasterSubfungsi, DataMasterSubfungsiEntity> implements DataMasterSubfungsiRepository {

	private final DataMasterSubfungsiJpaRepository repository;

	public DataMasterSubfungsiRepositoryImpl(DataMasterSubfungsiJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<DataMasterSubfungsiEntity, String> repository() {
		return repository;
	}

}