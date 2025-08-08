package com.rendyrobbani.keuangan.domain.entity.user;

import com.rendyrobbani.keuangan.common.marker.*;
import com.rendyrobbani.keuangan.common.vo.Gender;
import com.rendyrobbani.keuangan.common.vo.Pangkat;
import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDate;

public interface DataUser extends HasPangkat, HasNameAndTitle, HasLockMutator, HasAuditMutator {

	String getId();

	Nip getNip();

	Pangkat getPangkat();

	String getName();

	String getTitlePrefix();

	String getTitleSuffix();

	String getPassword();

	LocalDate getBirthDate();

	LocalDate getStartDate();

	Gender getGender();

	Integer getNumber();

	boolean isPNS();

	boolean isP3K();

	void setPangkat(Pangkat pangkat);

	void setName(String name);

	void setTitlePrefix(String titlePrefix);

	void setTitleSuffix(String titleSuffix);

	void setPassword(String password);

	void setStartDate(LocalDate startDate);

}