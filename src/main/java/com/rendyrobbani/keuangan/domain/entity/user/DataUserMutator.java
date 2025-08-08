package com.rendyrobbani.keuangan.domain.entity.user;

import com.rendyrobbani.keuangan.common.marker.HasAuditMutatorSupport;
import com.rendyrobbani.keuangan.common.marker.HasLockMutatorSupport;
import com.rendyrobbani.keuangan.common.vo.Gender;

import java.time.LocalDate;

public interface DataUserMutator extends DataUser, HasLockMutatorSupport, HasAuditMutatorSupport {

	void setBirthDate(LocalDate birthDate);

	void setStartDate(LocalDate startDate);

	void setGender(Gender gender);

	void setNumber(Integer number);

	void setPNS(boolean pns);

	void setP3K(boolean p3k);

}