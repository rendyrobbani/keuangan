package com.rendyrobbani.keuangan.core.common.vo;

import java.time.LocalDate;

record NipRecord(String simple,
                 String styled,
                 LocalDate dateOfBirth,
                 LocalDate dateOfStart,
                 Gender gender,
                 Integer number) implements Nip {

}