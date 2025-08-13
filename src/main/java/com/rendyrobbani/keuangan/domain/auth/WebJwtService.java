package com.rendyrobbani.keuangan.domain.auth;

public interface WebJwtService {

	String encode(WebJwtPayload payload);

	WebJwtPayload decode(String token);

	void setToken(WebJwtPayload payload);

	WebJwtPayload getToken();

	String getTokenAsString();

	String getTokenAsCookie();

}