package com.rendyrobbani.keuangan.infrastructure.security.jwt;

import com.rendyrobbani.keuangan.common.exception.http.UnauthorizedException;
import com.rendyrobbani.keuangan.domain.auth.WebJwtPayload;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class WebJwtServiceImpl implements WebJwtService {

	private static final String KEY_TAHUN = "tahun";

	private static final String KEY_USER = "idUser";

	@Value("${com.rendyrobbani.latte.tahun}")
	private Integer tahun;

	@Value("${com.rendyrobbani.latte.auth.token-expired}")
	private Integer expired;

	@Value("${com.rendyrobbani.latte.auth.token-name}")
	private String tokenName;

	private final SecretKey secretKey;

	private final DataUserRepository userRepository;

	public WebJwtServiceImpl(SecretKey secretKey, DataUserRepository userRepository) {
		this.secretKey = secretKey;
		this.userRepository = userRepository;
	}

	@Override
	public String encode(WebJwtPayload payload) {
		return payload == null ? null : Jwts.builder()
				.header()
				.add("alg", "hs256")
				.add("typ", "jwt")
				.add("env", "web")
				.and()
				.claim(KEY_TAHUN, this.tahun)
				.claim(KEY_USER, payload.user().id())
				.expiration(new Date(System.currentTimeMillis() + (1000 * 60 * expired.longValue())))
				.signWith(secretKey)
				.compact();
	}

	@Override
	public WebJwtPayload decode(String token) {
		if (token == null) return null;
		try {
			Claims payload = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
			var tahun = payload.get(KEY_TAHUN, Integer.class);
			if (tahun.intValue() != this.tahun.intValue()) throw new UnauthorizedException();

			var userId = payload.get(KEY_USER, String.class);
			if (userId == null) throw new UnauthorizedException();

			var user = userRepository.selectById(userId).orElseThrow(UnauthorizedException::new);

			return new WebJwtPayloadRecord(tahun, user);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void setToken(WebJwtPayload payload) {
		SecurityContextHolder.getContext().setAuthentication(payload == null ? null : new UsernamePasswordAuthenticationToken(payload, encode(payload), null));
	}

	@Override
	public WebJwtPayload getToken() {
		try {
			Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (o == null) return null;
			return (WebJwtPayload) o;
		} catch (Exception ignored) {
			return null;
		}
	}

	@Override
	public String getTokenAsString() {
		try {
			Object o = SecurityContextHolder.getContext().getAuthentication().getCredentials();
			if (o == null) return null;
			return (String) o;
		} catch (Exception ignored) {
			return null;
		}
	}

	@Override
	public String getTokenAsCookie() {
		var token = getTokenAsString();
		if (token == null) return "";
		return String.join("; ", tokenName + "=" + token, "Path=/", "SameSite=None", "Secure=false");
	}

}