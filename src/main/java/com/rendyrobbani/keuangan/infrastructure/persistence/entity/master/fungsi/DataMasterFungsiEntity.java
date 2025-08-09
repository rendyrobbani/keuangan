package com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.fungsi;

import com.rendyrobbani.keuangan.common.classification.fungsi.FungsiClassification;
import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.domain.entity.master.fungsi.DataMasterFungsiMutator;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.DataMasterEntity;
import com.rendyrobbani.keuangan.schema.table.master.fungsi.DataMasterFungsiTable;
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
@Table(name = DataMasterFungsiTable.NAME)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DataMasterFungsiEntity extends DataMasterEntity implements DataMasterFungsiMutator {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	public DataMasterFungsiEntity(LocalDateTime createdAt, Nip createdBy, FungsiClassification classification) {
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.id = classification.fungsiCode();
		this.code = classification.fungsiCode();

		this.isLocked = false;
		this.isDeleted = false;
	}

}