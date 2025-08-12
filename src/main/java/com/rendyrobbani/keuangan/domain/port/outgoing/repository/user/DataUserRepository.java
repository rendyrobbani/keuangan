package com.rendyrobbani.keuangan.domain.port.outgoing.repository.user;

import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.CreateRepository;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.SelectRepository;

public interface DataUserRepository extends SelectRepository<String, DataUser>,
                                            CreateRepository<DataUser> {

}