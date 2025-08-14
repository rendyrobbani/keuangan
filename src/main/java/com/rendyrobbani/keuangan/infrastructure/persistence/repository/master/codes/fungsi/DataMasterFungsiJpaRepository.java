package com.rendyrobbani.keuangan.infrastructure.persistence.repository.master.codes.fungsi;

import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.codes.fungsi.DataMasterFungsiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataMasterFungsiJpaRepository extends JpaRepository<DataMasterFungsiEntity, String> {

}