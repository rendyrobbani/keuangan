package com.rendyrobbani.keuangan.domain.auth;

import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;

public interface WebJwtService {

	String encode(WebJwtPayload payload);

	WebJwtPayload decode(String token);

	void setToken(WebJwtPayload payload);

	void setToken(DataUser user);

	WebJwtPayload getToken();

	String getTokenAsString();

	String getTokenAsCookie();

}