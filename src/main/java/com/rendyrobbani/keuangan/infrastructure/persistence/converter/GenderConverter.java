package com.rendyrobbani.keuangan.infrastructure.persistence.converter;

import com.rendyrobbani.keuangan.domain.model.vo.Gender;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public final class GenderConverter implements AttributeConverter<Gender, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Gender gender) {
		if (gender == null) return null;
		return gender.value();
	}

	@Override
	public Gender convertToEntityAttribute(Integer value) {
		if (value == null) return null;
		return Gender.fromValue(value);
	}

}