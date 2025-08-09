package com.rendyrobbani.keuangan.infrastructure.persistence.repository.master.urusan;

import com.rendyrobbani.keuangan.domain.entity.master.urusan.SipdMasterUrusan;
import com.rendyrobbani.keuangan.domain.repository.master.urusan.SipdMasterUrusanRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.urusan.SipdMasterUrusanEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.repository.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SipdMasterUrusanRepositoryImpl extends BaseRepositoryImpl<Long, SipdMasterUrusan, SipdMasterUrusanEntity> implements SipdMasterUrusanRepository {

	private final SipdMasterUrusanJpaRepository repository;

	public SipdMasterUrusanRepositoryImpl(SipdMasterUrusanJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<SipdMasterUrusanEntity, Long> repository() {
		return repository;
	}

}