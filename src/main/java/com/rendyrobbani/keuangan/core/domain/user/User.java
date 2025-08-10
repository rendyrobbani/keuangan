package com.rendyrobbani.keuangan.core.domain.user;

import com.rendyrobbani.keuangan.core.common.marker.HasNameOfPerson;
import com.rendyrobbani.keuangan.core.common.marker.HasPangkat;
import com.rendyrobbani.keuangan.core.common.vo.Gender;
import com.rendyrobbani.keuangan.core.common.vo.Nip;
import com.rendyrobbani.keuangan.core.common.vo.Pangkat;
import com.rendyrobbani.keuangan.core.common.vo.TypeOfASN;

import java.time.LocalDate;

public interface User extends HasPangkat,
                              HasNameOfPerson {

	Nip nip();

	@Override
	Pangkat pangkat();

	@Override
	String name();

	@Override
	String titlePrefix();

	@Override
	String titleSuffix();

	String password();

	LocalDate dateOfBirth();

	LocalDate dateOfStart();

	Gender gender();

	Integer number();

	TypeOfASN type();

	boolean isLocked();

	boolean isDeleted();

}