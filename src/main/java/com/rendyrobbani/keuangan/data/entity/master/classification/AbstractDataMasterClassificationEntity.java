package com.rendyrobbani.keuangan.data.entity.master.classification;

import com.rendyrobbani.keuangan.core.common.vo.Nip;
import com.rendyrobbani.keuangan.core.domain.master.classification.DataMasterClassification;
import com.rendyrobbani.keuangan.data.converter.NipConverter;
import com.rendyrobbani.keuangan.data.entity.master.AbstractDataMasterEntity;
import com.rendyrobbani.keuangan.data.support.HasLockSupport;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = false, fluent = true)
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractDataMasterClassificationEntity extends AbstractDataMasterEntity<String> implements DataMasterClassification,
                                                                                                                 HasLockSupport {

	@Id
	@Column(name = "id")
	protected String id;

	@Column(name = "code")
	protected String code;

	@Column(name = "name")
	protected String name;

	@Column(name = "is_locked")
	protected boolean isLocked;

	@Column(name = "locked_at")
	protected LocalDateTime lockedAt;

	@Convert(converter = NipConverter.class)
	@Column(name = "locked_by")
	protected Nip lockedBy;

	@Override
	public void delete(LocalDateTime deletedAt,
	                   Nip deletedBy) {
		this.lock(deletedAt, deletedBy);
		super.delete(deletedAt, deletedBy);
	}

}