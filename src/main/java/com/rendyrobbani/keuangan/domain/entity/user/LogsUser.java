package com.rendyrobbani.keuangan.domain.entity.user;

import com.rendyrobbani.keuangan.common.marker.HasId;
import com.rendyrobbani.keuangan.common.marker.HasLoggable;
import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDateTime;

public interface LogsUser extends BaseUser, HasId<Long>, HasLoggable<DataUser, String> {

	@Override
	default void log(LocalDateTime loggedAt, Nip loggedBy, DataUser subject) {
		HasLoggable.super.log(loggedAt, loggedBy, subject);

		this.setSubjectId(subject.getId());
		this.setPangkat(subject.getPangkat());
		this.setName(subject.getName());
		this.setTitlePrefix(subject.getTitlePrefix());
		this.setTitleSuffix(subject.getTitleSuffix());
		this.setPassword(subject.getPassword());
		this.setBirthDate(subject.getBirthDate());
		this.setStartDate(subject.getStartDate());
		this.setGender(subject.getGender());
		this.setNumber(subject.getNumber());
		this.setLocked(subject.isLocked());
		this.setLockedAt(subject.getLockedAt());
		this.setLockedBy(subject.getLockedBy());
		this.setCreatedAt(subject.getCreatedAt());
		this.setCreatedBy(subject.getCreatedBy());
		this.setUpdatedAt(subject.getUpdatedAt());
		this.setUpdatedBy(subject.getUpdatedBy());
		this.setDeleted(subject.isDeleted());
		this.setDeletedAt(subject.getDeletedAt());
		this.setDeletedBy(subject.getDeletedBy());
	}

}