package com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.urusan;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.domain.entity.master.urusan.SipdMasterUrusanMutator;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.master.SipdMasterEntity;
import com.rendyrobbani.keuangan.schema.table.master.urusan.SipdMasterUrusanTable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = SipdMasterUrusanTable.NAME)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SipdMasterUrusanEntity extends SipdMasterEntity implements SipdMasterUrusanMutator {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "data_id")
	private String dataId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "data_id", referencedColumnName = "id", insertable = false, updatable = false)
	private DataMasterUrusanEntity data;

	public SipdMasterUrusanEntity(LocalDateTime createdAt, Nip createdBy, Long id, DataMasterUrusanEntity data) {
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.id = id;
		this.data = data;
		this.dataId = data.getId();

		this.isLocked = false;
		this.isDeleted = false;
	}

}