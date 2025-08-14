package com.rendyrobbani.keuangan.domain.model.dto.web.user;

public interface WebUserSelectResponse {

	String id();

	String simpleNip();

	String styledNip();

	String pangkatTitle();

	String onlyName();

	String fullName();

	boolean isLocked();

	boolean isDeleted();

}