package com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.subfungsi;

import com.rendyrobbani.keuangan.common.classification.subfungsi.SubfungsiClassification;
import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.domain.entity.master.subfungsi.DataMasterSubfungsiMutator;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.DataMasterEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.fungsi.DataMasterFungsiEntity;
import com.rendyrobbani.keuangan.schema.table.master.subfungsi.DataMasterSubfungsiTable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = DataMasterSubfungsiTable.NAME)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DataMasterSubfungsiEntity extends DataMasterEntity implements DataMasterSubfungsiMutator {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "fungsi_id")
	private String fungsiId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fungsi_id", referencedColumnName = "id", insertable = false, updatable = false)
	private DataMasterFungsiEntity fungsi;

	public DataMasterSubfungsiEntity(LocalDateTime createdAt, Nip createdBy, SubfungsiClassification classification) {
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.id = classification.subfungsiCode();
		this.code = classification.subfungsiCode();

		this.isLocked = false;
		this.isDeleted = false;

		this.fungsiId = classification.fungsiCode();
	}

}