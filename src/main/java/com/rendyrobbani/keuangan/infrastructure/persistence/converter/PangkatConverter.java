package com.rendyrobbani.keuangan.infrastructure.persistence.converter;

import com.rendyrobbani.keuangan.domain.model.vo.Pangkat;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public final class PangkatConverter implements AttributeConverter<Pangkat, String> {

	@Override
	public String convertToDatabaseColumn(Pangkat pangkat) {
		if (pangkat == null) return null;
		return pangkat.value();
	}

	@Override
	public Pangkat convertToEntityAttribute(String value) {
		if (value == null) return null;
		return Pangkat.fromValue(value);
	}

}