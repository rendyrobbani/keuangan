package com.rendyrobbani.keuangan.common.vo.nip;

import com.rendyrobbani.keuangan.common.vo.Gender;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
@SuppressWarnings("ClassCanBeRecord")
public final class NipImpl implements Nip {

	private final String value;

	private final String formatted;

	private final LocalDate birthDate;

	private final LocalDate startDate;

	private final Gender gender;

	private final Integer number;

}