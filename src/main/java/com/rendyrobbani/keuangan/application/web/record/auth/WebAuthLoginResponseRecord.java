package com.rendyrobbani.keuangan.application.web.record.auth;

import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthLoginResponse;
import com.rendyrobbani.keuangan.domain.model.vo.Gender;

import java.time.LocalDate;

public record WebAuthLoginResponseRecord(String simpleNip,
                                         String styledNip,
                                         String pangkatValue,
                                         String pangkatTitle,
                                         String onlyName,
                                         String fullName,
                                         String titlePrefix,
                                         String titleSuffix,
                                         LocalDate dateOfBirth,
                                         LocalDate dateOfStart,
                                         Gender gender,
                                         Integer number) implements WebAuthLoginResponse {

}