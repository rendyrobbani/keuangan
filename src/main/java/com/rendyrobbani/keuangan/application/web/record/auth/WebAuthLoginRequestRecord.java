package com.rendyrobbani.keuangan.application.web.record.auth;

import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthLoginRequest;
import com.rendyrobbani.keuangan.domain.model.vo.Role;

public record WebAuthLoginRequestRecord(Role role) implements WebAuthLoginRequest {

}