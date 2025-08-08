package com.rendyrobbani.keuangan.common.marker;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDateTime;

public interface HasLoggable<SUBJECT, SUBJECTID> {

	LocalDateTime getLoggedAt();

	void setLoggedAt(LocalDateTime loggedAt);

	Nip getLoggedBy();

	void setLoggedBy(Nip loggedBy);

	SUBJECT getSubject();

	void setSubject(SUBJECT subject);

	SUBJECTID getSubjectId();

	void setSubjectId(SUBJECTID subjectId);

	default void log(LocalDateTime loggedAt, Nip loggedBy, SUBJECT subject) {
		this.setLoggedAt(loggedAt);
		this.setLoggedBy(loggedBy);
		this.setSubject(subject);
	}

}