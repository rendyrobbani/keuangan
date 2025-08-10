package com.rendyrobbani.keuangan.data.entity.user;

import com.rendyrobbani.keuangan.data.entity.AbstractLogsEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = false, fluent = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "logs_user")
public class LogsUserEntity extends AbstractLogsEntity<String, DataUserEntity> {

	@Column(name = "subject_id")
	private String subjectId;

	@Setter(AccessLevel.NONE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id", referencedColumnName = "id", insertable = false, updatable = false)
	private DataUserEntity subject;

}