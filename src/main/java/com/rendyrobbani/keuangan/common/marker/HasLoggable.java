package com.rendyrobbani.keuangan.common.marker;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDateTime;

public interface HasLoggable<Subject, SubjectID> {

	LocalDateTime getLoggedAt();

	void setLoggedAt(LocalDateTime loggedAt);

	Nip getLoggedBy();

	void setLoggedBy(Nip loggedBy);

	Subject getSubject();

	void setSubject(Subject subject);

	SubjectID getSubjectId();

	void setSubjectId(SubjectID subjectId);

	default void log(LocalDateTime loggedAt, Nip loggedBy, Subject subject) {
		this.setLoggedAt(loggedAt);
		this.setLoggedBy(loggedBy);
		this.setSubject(subject);
	}

}