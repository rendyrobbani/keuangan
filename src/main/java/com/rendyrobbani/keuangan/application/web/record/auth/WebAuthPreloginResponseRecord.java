package com.rendyrobbani.keuangan.application.web.record.auth;

import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthPreloginResponse;

public record WebAuthPreloginResponseRecord(String onlyName,
                                            String fullName) implements WebAuthPreloginResponse {

}