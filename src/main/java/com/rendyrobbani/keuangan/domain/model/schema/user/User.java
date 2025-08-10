package com.rendyrobbani.keuangan.domain.model.schema.user;

import com.rendyrobbani.keuangan.domain.model.schema.master.pegawai.Pegawai;
import com.rendyrobbani.keuangan.domain.model.shared.HasAuthentication;

public interface User extends Pegawai,
                              HasAuthentication {

}