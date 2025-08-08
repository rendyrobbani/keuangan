package com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.bidang;

import com.rendyrobbani.keuangan.common.classification.bidang.BidangClassification;
import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.domain.entity.master.bidang.DataMasterBidangMutator;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.DataMasterEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.urusan.DataMasterUrusanEntity;
import com.rendyrobbani.keuangan.schema.table.master.bidang.DataMasterBidangTable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = DataMasterBidangTable.NAME)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DataMasterBidangEntity extends DataMasterEntity implements DataMasterBidangMutator {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "urusan_id")
	private String urusanId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "urusan_id", referencedColumnName = "id", insertable = false, updatable = false)
	private DataMasterUrusanEntity urusan;

	public DataMasterBidangEntity(LocalDateTime createdAt, Nip createdBy, BidangClassification classification) {
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.id = classification.getBidangCode().replaceAll("X", "0");
		this.code = classification.getBidangCode();

		this.isLocked = false;
		this.isDeleted = false;

		this.urusanId = classification.getUrusanCode().replaceAll("X", "0");
	}

}