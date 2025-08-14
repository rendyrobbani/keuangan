package com.rendyrobbani.keuangan.application.web.record.master.fungsi;

import com.rendyrobbani.keuangan.common.util.text.TextUtil;
import com.rendyrobbani.keuangan.domain.model.dto.web.master.fungsi.WebMasterFungsiUpdateRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record WebMasterFungsiUpdateRequestRecord(@NotNull @NotBlank String name) implements WebMasterFungsiUpdateRequest {

	@Override
	public String name() {
		return TextUtil.trim(name);
	}

}