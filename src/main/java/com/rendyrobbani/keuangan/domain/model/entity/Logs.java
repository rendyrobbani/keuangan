package com.rendyrobbani.keuangan.domain.model.entity;

public interface Logs<SUBJECT, SUBJECTID> extends Base<Long> {

	SUBJECTID subjectId();

}