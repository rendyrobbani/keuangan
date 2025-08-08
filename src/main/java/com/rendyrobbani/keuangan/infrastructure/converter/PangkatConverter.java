package com.rendyrobbani.keuangan.infrastructure.converter;

import com.rendyrobbani.keuangan.common.vo.Pangkat;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public final class PangkatConverter implements AttributeConverter<Pangkat, String> {

	@Override
	public String convertToDatabaseColumn(Pangkat pangkat) {
		if (pangkat == null) return null;
		return pangkat.getValue();
	}

	@Override
	public Pangkat convertToEntityAttribute(String value) {
		if (value == null) return null;
		return Pangkat.fromValue(value);
	}

}