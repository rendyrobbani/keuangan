package com.rendyrobbani.keuangan.application.web.record.master.fungsi;

import com.rendyrobbani.keuangan.common.codes.fungsi.FungsiCodes;
import com.rendyrobbani.keuangan.common.util.text.TextUtil;
import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiCreateRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record WebMasterFungsiCreateRequestRecord(@NotNull FungsiCodes code,
                                                 @NotNull @NotBlank String name) implements WebMasterFungsiCreateRequest {

	@Override
	public String name() {
		return TextUtil.trim(name);
	}

}