package com.rendyrobbani.keuangan.domain.entity.user;

import com.rendyrobbani.keuangan.common.marker.*;
import com.rendyrobbani.keuangan.common.vo.Gender;

import java.time.LocalDate;

public interface BaseUser extends HasNip, HasPangkat, HasNameAndTitle, HasLockable {

	String getPassword();

	void setPassword(String password);

	LocalDate getBirthDate();

	void setBirthDate(LocalDate birthDate);

	LocalDate getStartDate();

	void setStartDate(LocalDate startDate);

	Gender getGender();

	void setGender(Gender gender);

	Integer getNumber();

	void setNumber(Integer number);

	boolean isPNS();

	void setPNS(boolean isPNS);

	boolean isP3K();

	void setP3K(boolean isP3K);

}