package com.rendyrobbani.keuangan.presentation.web.auth;

import com.rendyrobbani.keuangan.application.web.record.auth.WebAuthPreloginRequestRecord;
import com.rendyrobbani.keuangan.domain.port.incoming.web.auth.WebAuthPreloginService;
import com.rendyrobbani.keuangan.presentation.web.common.WebResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WebAuthController {

	private final WebResponse response;

	private final WebAuthPreloginService preloginService;

	@PostMapping("/web/auth/prelogin")
	public ResponseEntity<?> prelogin(@RequestBody WebAuthPreloginRequestRecord request) {
		var response = preloginService.prelogin(request);
		return this.response.success(response);
	}

}