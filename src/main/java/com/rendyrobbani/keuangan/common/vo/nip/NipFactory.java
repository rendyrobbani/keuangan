package com.rendyrobbani.keuangan.common.vo.nip;

import com.rendyrobbani.keuangan.common.vo.Gender;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NipFactory {
	private static DateTimeFormatter formatter;

	private static DateTimeFormatter getFormatter() {
		if (formatter == null) formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		return formatter;
	}

	private static int[] mapOfBirthDate;

	private static int[] getMapOfBirthDate() {
		if (mapOfBirthDate == null) mapOfBirthDate = new int[]{0, 8};
		return mapOfBirthDate;
	}

	private static int[] mapOfStartDate;

	private static int[] getMapOfStartDate() {
		if (mapOfStartDate == null) mapOfStartDate = new int[]{8, 14};
		return mapOfStartDate;
	}

	private static int[] mapOfGender;

	private static int[] getMapOfGender() {
		if (mapOfGender == null) mapOfGender = new int[]{14, 15};
		return mapOfGender;
	}

	private static int[] mapOfNumber;

	private static int[] getMapOfNumber() {
		if (mapOfNumber == null) mapOfNumber = new int[]{15, 18};
		return mapOfNumber;
	}

	public static Nip parse(String value) {
		if (value == null) return null;

		if (!value.matches(Nip.REGEX)) return null;

		var valueOfBirthDate = value.substring(getMapOfBirthDate()[0], getMapOfBirthDate()[1]);
		var valueOfStartDate = value.substring(getMapOfStartDate()[0], getMapOfStartDate()[1]);
		var valueOfGender = value.substring(getMapOfGender()[0], getMapOfGender()[1]);
		var valueOfNumber = value.substring(getMapOfNumber()[0], getMapOfNumber()[1]);

		return new NipImpl(value,
		                   String.join(" ", valueOfBirthDate, valueOfStartDate, valueOfGender, valueOfNumber),
		                   LocalDate.parse(valueOfBirthDate, getFormatter()),
		                   valueOfStartDate.endsWith("21") ? null : LocalDate.parse(valueOfStartDate + "01", getFormatter()),
		                   Gender.fromValue(valueOfGender),
		                   Integer.valueOf(valueOfNumber)
		);
	}
}