package com.rendyrobbani.keuangan.domain.model.response.web.user.data;

public interface WebUserDataSelectResponse {

	String id();

	String simpleNip();

	String styledNip();

	String pangkatTitle();

	String onlyName();

	String fullName();

	boolean isLocked();

	boolean isDeleted();

}