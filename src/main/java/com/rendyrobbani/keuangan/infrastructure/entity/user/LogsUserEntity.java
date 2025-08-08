package com.rendyrobbani.keuangan.infrastructure.entity.user;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.domain.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.entity.user.LogsUser;
import com.rendyrobbani.keuangan.infrastructure.converter.NipConverter;
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

	@Convert(converter = NipConverter.class)
	@Column(name = "subject_id", insertable = false, updatable = false)
	private Nip nip;

	@Column(name = "subject_id")
	private String subjectId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id", insertable = false, updatable = false)
	private DataUserEntity subject;

	@Column(name = "logged_at")
	private LocalDateTime loggedAt;

	@Convert(converter = NipConverter.class)
	@Column(name = "logged_by")
	private Nip loggedBy;

	@Override
	public void setSubject(DataUser user) {
		this.subject = (DataUserEntity) user;
	}

}