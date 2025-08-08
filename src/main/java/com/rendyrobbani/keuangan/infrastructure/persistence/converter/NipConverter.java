package com.rendyrobbani.keuangan.infrastructure.persistence.converter;

import com.rendyrobbani.keuangan.common.vo.nip.Nip;
import com.rendyrobbani.keuangan.common.vo.nip.NipFactory;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public final class NipConverter implements AttributeConverter<Nip, String> {

	@Override
	public String convertToDatabaseColumn(Nip nip) {
		if (nip == null) return null;
		return nip.getValue();
	}

	@Override
	public Nip convertToEntityAttribute(String value) {
		if (value == null) return null;
		return NipFactory.parse(value);
	}

}