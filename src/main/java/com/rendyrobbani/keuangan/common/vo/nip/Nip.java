package com.rendyrobbani.keuangan.common.vo.nip;

import com.rendyrobbani.keuangan.common.vo.Gender;

import java.time.LocalDate;

public interface Nip {

	String REGEX = "^(19[0-9]{2}|20[0-9]{2})(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])(19[0-9]{2}|20[0-9]{2})(0[1-9]|1[0-2]|21)([12])(00[1-9]|[0-9][1-9][0-9]|[1-9][0-9][0-9])$";

	String value();

	String formatted();

	LocalDate birthDate();

	LocalDate startDate();

	Gender gender();

	Integer number();

}