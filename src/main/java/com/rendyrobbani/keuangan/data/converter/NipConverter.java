package com.rendyrobbani.keuangan.data.converter;

import com.rendyrobbani.keuangan.core.common.vo.Nip;
import com.rendyrobbani.keuangan.core.common.vo.NipFactory;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class NipConverter implements AttributeConverter<Nip, String> {

	@Override
	public String convertToDatabaseColumn(Nip nip) {
		if (nip == null) return null;
		return nip.simple();
	}

	@Override
	public Nip convertToEntityAttribute(String value) {
		if (value == null) return null;
		return NipFactory.create(value);
	}

}