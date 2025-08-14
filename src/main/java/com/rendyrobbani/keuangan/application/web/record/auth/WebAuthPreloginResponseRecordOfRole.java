package com.rendyrobbani.keuangan.application.web.record.auth;

import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthPreloginResponseOfRole;

public record WebAuthPreloginResponseRecordOfRole(Integer value,
                                                  String title) implements WebAuthPreloginResponseOfRole {

}