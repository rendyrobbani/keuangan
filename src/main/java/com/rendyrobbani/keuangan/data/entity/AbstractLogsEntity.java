package com.rendyrobbani.keuangan.data.entity;

import com.rendyrobbani.keuangan.core.common.vo.Nip;
import com.rendyrobbani.keuangan.core.domain.BaseLogs;
import com.rendyrobbani.keuangan.data.converter.NipConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = false, fluent = true)
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractLogsEntity<SUBJECTID, SUBJECT extends AbstractDataEntity<SUBJECTID>> implements BaseLogs<SUBJECTID, SUBJECT>,
                                                                                                              Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Column(name = "created_at")
	protected LocalDateTime createdAt;

	@Convert(converter = NipConverter.class)
	@Column(name = "created_by")
	protected Nip createdBy;

	@Column(name = "updated_at")
	protected LocalDateTime updatedAt;

	@Convert(converter = NipConverter.class)
	@Column(name = "updated_by")
	protected Nip updatedBy;

	@Column(name = "is_deleted")
	protected boolean isDeleted;

	@Column(name = "deleted_at")
	protected LocalDateTime deletedAt;

	@Convert(converter = NipConverter.class)
	@Column(name = "deleted_by")
	protected Nip deletedBy;

}