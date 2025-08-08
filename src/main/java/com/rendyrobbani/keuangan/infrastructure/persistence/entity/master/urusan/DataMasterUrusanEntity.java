package com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.urusan;

import com.rendyrobbani.keuangan.common.classification.urusan.UrusanClassification;
import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.domain.entity.master.urusan.DataMasterUrusanMutator;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.DataMasterEntity;
import com.rendyrobbani.keuangan.schema.table.master.urusan.DataMasterUrusanTable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = DataMasterUrusanTable.NAME)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DataMasterUrusanEntity extends DataMasterEntity implements DataMasterUrusanMutator {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	public DataMasterUrusanEntity(LocalDateTime createdAt, Nip createdBy, UrusanClassification classification) {
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.id = classification.getUrusanCode().replaceAll("X", "0");
		this.code = classification.getUrusanCode();

		this.isLocked = false;
		this.isDeleted = false;
	}

}