package com.rendyrobbani.keuangan.domain.entity.user;

import com.rendyrobbani.keuangan.common.marker.HasAuditable;
import com.rendyrobbani.keuangan.common.marker.HasLockable;
import com.rendyrobbani.keuangan.common.marker.HasNameAndTitle;
import com.rendyrobbani.keuangan.common.marker.HasPangkat;
import com.rendyrobbani.keuangan.common.vo.Gender;

import java.time.LocalDate;

public interface BaseUser extends HasPangkat, HasNameAndTitle, HasLockable, HasAuditable {

	String getPassword();

	LocalDate getBirthDate();

	LocalDate getStartDate();

	Gender getGender();

	Integer getNumber();

	boolean isPNS();

	boolean isP3K();

}