package com.rendyrobbani.keuangan.infrastructure.persistence.repository.master.codes.fungsi;

import com.rendyrobbani.keuangan.domain.model.entity.master.codes.fungsi.DataMasterFungsi;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.master.codes.fungsi.DataMasterFungsiRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.codes.fungsi.DataMasterFungsiEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.repository.master.codes.AbstractDataMasterCodesRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DataMasterFungsiRepositoryImpl extends AbstractDataMasterCodesRepositoryImpl<DataMasterFungsiEntity, DataMasterFungsi> implements DataMasterFungsiRepository {

	private final DataMasterFungsiJpaRepository repository;

	@Override
	public DataMasterFungsiEntity instance() {
		return new DataMasterFungsiEntity();
	}

	@Override
	public JpaRepository<DataMasterFungsiEntity, String> repository() {
		return repository;
	}

}