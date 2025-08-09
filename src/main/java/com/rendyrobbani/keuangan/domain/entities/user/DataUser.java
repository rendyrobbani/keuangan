package com.rendyrobbani.keuangan.domain.entities.user;

import com.rendyrobbani.keuangan.common.vo.Gender;
import com.rendyrobbani.keuangan.common.vo.Pangkat;
import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.domain.marker.HasDelete;
import com.rendyrobbani.keuangan.domain.marker.HasLock;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface DataUser extends HasLock,
                                  HasDelete {

	String id();

	Nip nip();

	Pangkat pangkat();

	String name();

	String onlyName(boolean toUpperCase);

	default String onlyName() {
		return this.onlyName(false);
	}

	String fullName(boolean toUpperCase);

	default String fullName() {
		return this.onlyName(false);
	}

	String titlePrefix();

	String titleSuffix();

	String password();

	LocalDate birthDate();

	LocalDate startDate();

	Gender gender();

	Integer number();

	boolean isPNS();

	boolean isP3K();

	boolean isLocked();

	boolean isDeleted();

	void create(Nip nip,
	            Pangkat pangkat,
	            String name,
	            String titlePrefix,
	            String titleSuffix,
	            String password,
	            LocalDate startDate,
	            LocalDateTime createdAt,
	            Nip createdBy);

	void update(Pangkat pangkat,
	            String name,
	            String titlePrefix,
	            String titleSuffix,
	            String password,
	            LocalDate startDate,
	            LocalDateTime updatedAt,
	            Nip updatedBy);

}