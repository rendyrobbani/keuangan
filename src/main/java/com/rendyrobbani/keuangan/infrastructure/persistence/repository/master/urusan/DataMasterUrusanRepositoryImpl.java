package com.rendyrobbani.keuangan.infrastructure.persistence.repository.master.urusan;

import com.rendyrobbani.keuangan.domain.entity.master.urusan.DataMasterUrusan;
import com.rendyrobbani.keuangan.domain.repository.master.urusan.DataMasterUrusanRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.urusan.DataMasterUrusanEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.repository.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataMasterUrusanRepositoryImpl extends BaseRepositoryImpl<String, DataMasterUrusan, DataMasterUrusanEntity> implements DataMasterUrusanRepository {

	private final DataMasterUrusanJpaRepository repository;

	public DataMasterUrusanRepositoryImpl(DataMasterUrusanJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<DataMasterUrusanEntity, String> repository() {
		return repository;
	}

}