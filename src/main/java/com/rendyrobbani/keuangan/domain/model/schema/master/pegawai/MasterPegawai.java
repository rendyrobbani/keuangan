package com.rendyrobbani.keuangan.domain.model.schema.master.pegawai;

import com.rendyrobbani.keuangan.domain.model.shared.HasNameAndTitles;
import com.rendyrobbani.keuangan.domain.model.shared.HasNip;
import com.rendyrobbani.keuangan.domain.model.shared.HasPangkat;
import com.rendyrobbani.keuangan.domain.model.vo.Gender;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.model.vo.Pangkat;

import java.time.LocalDate;

public interface MasterPegawai extends HasNip,
                                       HasPangkat,
                                       HasNameAndTitles {

	@Override
	Nip nip();

	@Override
	Pangkat pangkat();

	@Override
	String name();

	@Override
	String titlePrefix();

	@Override
	String titleSuffix();

	LocalDate dateOfBirth();

	LocalDate dateOfStart();

	Gender gender();

	Integer number();

	boolean isPNS();

	boolean isP3K();

}