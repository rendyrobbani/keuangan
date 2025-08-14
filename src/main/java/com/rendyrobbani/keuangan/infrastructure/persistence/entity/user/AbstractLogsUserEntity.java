package com.rendyrobbani.keuangan.infrastructure.persistence.entity.user;

import com.rendyrobbani.keuangan.domain.model.entity.user.LogsUser;
import com.rendyrobbani.keuangan.domain.model.vo.Gender;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.model.vo.Pangkat;
import com.rendyrobbani.keuangan.infrastructure.persistence.converter.GenderConverter;
import com.rendyrobbani.keuangan.infrastructure.persistence.converter.NipConverter;
import com.rendyrobbani.keuangan.infrastructure.persistence.converter.PangkatConverter;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.AbstractLogsEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = false, fluent = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public abstract class AbstractLogsUserEntity extends AbstractLogsEntity<LogsUser, String> implements LogsUser {

	@Column(name = "subject_id")
	protected String subjectId;

	@Convert(converter = NipConverter.class)
	@Column(name = "id", insertable = false, updatable = false)
	protected Nip nip;

	@Convert(converter = PangkatConverter.class)
	@Column(name = "pangkat")
	protected Pangkat pangkat;

	@Column(name = "name")
	protected String name;

	@Column(name = "title_prefix")
	protected String titlePrefix;

	@Column(name = "title_suffix")
	protected String titleSuffix;

	@Column(name = "password")
	protected String password;

	@Column(name = "date_of_birth")
	protected LocalDate dateOfBirth;

	@Column(name = "date_of_start")
	protected LocalDate dateOfStart;

	@Convert(converter = GenderConverter.class)
	@Column(name = "gender")
	protected Gender gender;

	@Column(name = "number")
	protected Integer number;

	@Column(name = "is_pns")
	protected boolean isPNS;

	@Column(name = "is_p3k")
	protected boolean isP3K;

	@Column(name = "is_locked")
	protected boolean isLocked;

	@Column(name = "is_deleted")
	protected boolean isDeleted;

	@Override
	public void sync(LogsUser domain) {
		this.subjectId(domain.subjectId());
		this.nip(domain.nip());
		this.pangkat(domain.pangkat());
		this.name(domain.name());
		this.titlePrefix(domain.titlePrefix());
		this.titleSuffix(domain.titleSuffix());
		this.password(domain.password());
		this.dateOfBirth(domain.dateOfBirth());
		this.dateOfStart(domain.dateOfStart());
		this.gender(domain.gender());
		this.number(domain.number());
		this.isPNS(domain.isPNS());
		this.isP3K(domain.isP3K());
		this.isLocked(domain.isLocked());
		this.isDeleted(domain.isDeleted());
	}

}