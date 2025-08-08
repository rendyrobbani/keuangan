package com.rendyrobbani.keuangan.common.schema.constraint.check;

import com.rendyrobbani.keuangan.common.util.number.NumberUtil;
import com.rendyrobbani.keuangan.common.vo.Gender;
import com.rendyrobbani.keuangan.common.vo.Pangkat;
import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CheckConstraintFactory {

	public static CheckConstraint create(String name, String logic) {
		return new CheckConstraintImpl(name, logic);
	}

	public static CheckConstraint create(String tableName, Integer index, String logic) {
		return create(String.join("_", "ck", tableName.substring(0, Math.min(58, tableName.length())), NumberUtil.lpadZero(index, 2)), logic);
	}

	public static CheckConstraint columnRegex(String tableName, Integer index, String columnName, String regex) {
		var logic = columnName + " regexp '" + regex + "'";
		return create(tableName, index, logic);
	}

	public static CheckConstraint columnIn(String tableName, Integer index, String columnName, String[] values) {
		var inValues = String.join(", ", Stream.of(values).map(value -> "'" + value + "'").toArray(String[]::new));
		var logic = columnName + " in (" + inValues + ")";
		return create(tableName, index, logic);
	}

	public static CheckConstraint columnIn(String tableName, Integer index, String columnName, Integer[] values) {
		var inValues = String.join(", ", Stream.of(values).map(String::valueOf).toArray(String[]::new));
		var logic = columnName + " in (" + inValues + ")";
		return create(tableName, index, logic);
	}

	public static CheckConstraint columnBetween(String tableName, Integer index, String columnName, Integer min, Integer max) {
		var logic = columnName + " between " + min + " and " + max;
		return create(tableName, index, logic);
	}

	public static CheckConstraint columnIsNip(String tableName, Integer index, String columnName) {
		return columnRegex(tableName, index, columnName, Nip.REGEX);
	}

	public static CheckConstraint columnPangkat(String tableName, Integer index, String columnName) {
		return columnRegex(tableName, index, columnName, Pangkat.REGEX_PNS + "|" + Pangkat.REGEX_P3K);
	}

	public static CheckConstraint columnGender(String tableName, Integer index, String columnName) {
		return columnIn(tableName, index, columnName, Arrays.stream(Gender.values()).map(Gender::getValue).toArray(Integer[]::new));
	}

}