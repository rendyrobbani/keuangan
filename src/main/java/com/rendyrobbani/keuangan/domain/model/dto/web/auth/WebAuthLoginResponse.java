package com.rendyrobbani.keuangan.domain.model.dto.web.auth;

import com.rendyrobbani.keuangan.domain.model.vo.Gender;

import java.time.LocalDate;

public interface WebAuthLoginResponse {

	String simpleNip();

	String styledNip();

	String pangkatValue();

	String pangkatTitle();

	String onlyName();

	String fullName();

	String titlePrefix();

	String titleSuffix();

	LocalDate dateOfBirth();

	LocalDate dateOfStart();

	Gender gender();

	Integer number();

}