package com.rendyrobbani.keuangan.infrastructure.persistence.entity.user;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.domain.entity.user.LogsUser;
import com.rendyrobbani.keuangan.infrastructure.persistence.converter.NipConverter;
import com.rendyrobbani.keuangan.schema.table.user.LogsUserTable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = LogsUserTable.NAME)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LogsUserEntity extends BaseUserEntity implements LogsUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "logged_at")
	private LocalDateTime loggedAt;

	@Convert(converter = NipConverter.class)
	@Column(name = "logged_by")
	private Nip loggedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id", referencedColumnName = "id")
	private DataUserEntity subject;

	LogsUserEntity(LocalDateTime loggedAt, Nip loggedBy, DataUserEntity subject) {
		this.loggedAt = loggedAt;
		this.loggedBy = loggedBy;
		this.subject = subject;

		this.pangkat = subject.getPangkat();
		this.name = subject.getName();
		this.titlePrefix = subject.getTitlePrefix();
		this.titleSuffix = subject.getTitleSuffix();
		this.password = subject.getPassword();
		this.birthDate = subject.getBirthDate();
		this.startDate = subject.getStartDate();
		this.gender = subject.getGender();
		this.number = subject.getNumber();
		this.isPNS = subject.isPNS();
		this.isP3K = subject.isP3K();
		this.isLocked = subject.isLocked();
		this.lockedAt = subject.getLockedAt();
		this.lockedBy = subject.getLockedBy();
		this.createdAt = subject.getCreatedAt();
		this.createdBy = subject.getCreatedBy();
		this.updatedAt = subject.getUpdatedAt();
		this.updatedBy = subject.getUpdatedBy();
		this.isDeleted = subject.isDeleted();
		this.deletedAt = subject.getDeletedAt();
		this.deletedBy = subject.getDeletedBy();
	}

}