package com.rendyrobbani.keuangan.application.web.record.auth;

import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthPreloginResponse;
import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthPreloginResponseOfRole;

import java.util.List;

public record WebAuthPreloginResponseRecord(String onlyName,
                                            String fullName,
                                            List<WebAuthPreloginResponseOfRole> listOfRole) implements WebAuthPreloginResponse {

}