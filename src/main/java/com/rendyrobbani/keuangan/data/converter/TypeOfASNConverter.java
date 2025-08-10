package com.rendyrobbani.keuangan.data.converter;

import com.rendyrobbani.keuangan.core.common.vo.TypeOfASN;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TypeOfASNConverter implements AttributeConverter<TypeOfASN, Integer> {

	@Override
	public Integer convertToDatabaseColumn(TypeOfASN typeOfASN) {
		if (typeOfASN == null) return null;
		return typeOfASN.value();
	}

	@Override
	public TypeOfASN convertToEntityAttribute(Integer value) {
		if (value == null) return null;
		return TypeOfASN.fromValue(value);
	}

}