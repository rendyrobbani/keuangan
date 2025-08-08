package com.rendyrobbani.keuangan.domain.entity.user;

import com.rendyrobbani.keuangan.common.marker.*;
import com.rendyrobbani.keuangan.common.vo.Pangkat;
import com.rendyrobbani.keuangan.common.vo.nip.Nip;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface DataUser extends BaseUser, HasNameAndTitleMutator, HasLockMutator, HasAuditMutator {

	String getId();

	Nip getNip();

	void setPangkat(Pangkat pangkat);

	void setPassword(String password);

	void setStartDate(LocalDate startDate);

	LogsUser toLog(LocalDateTime loggedAt, Nip loggedBy);

}