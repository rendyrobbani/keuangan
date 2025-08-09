package com.rendyrobbani.keuangan.application.core.factory.master.urusan;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.domain.entity.master.urusan.SipdMasterUrusan;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.urusan.DataMasterUrusanEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.urusan.SipdMasterUrusanEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SipdMasterUrusanFactory {

	public static SipdMasterUrusan create(LocalDateTime createdAt, Nip createdBy, Long id, DataMasterUrusanEntity data) {
		return new SipdMasterUrusanEntity(createdAt, createdBy, id, data);
	}

}