package com.rendyrobbani.keuangan.application.web.service.user;

import com.rendyrobbani.keuangan.application.web.mapper.user.WebUserDataMapper;
import com.rendyrobbani.keuangan.common.exception.http.BadRequestException;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.data.WebUserDataCreateRequest;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.data.WebUserDataDetailResponse;
import com.rendyrobbani.keuangan.domain.port.incoming.web.user.WebUserDataCreateService;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class WebUserDataCreateServiceImpl implements WebUserDataCreateService {

	@Value("${com.rendyrobbani.latte.auth.default-password}")
	private String defaultPassword;

	private final WebJwtService webJwtService;

	private final Validator validator;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final DataUserRepository dataRepository;

	public WebUserDataCreateServiceImpl(WebJwtService webJwtService,
	                                    Validator validator,
	                                    BCryptPasswordEncoder bCryptPasswordEncoder,
	                                    DataUserRepository dataRepository) {
		this.webJwtService = webJwtService;
		this.validator = validator;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.dataRepository = dataRepository;
	}

	@Override
	@Transactional
	public WebUserDataDetailResponse create(WebUserDataCreateRequest request) {
		var actionAt = LocalDateTime.now();
		var actionBy = webJwtService.getToken().user().nip();

		var violations = validator.validate(request);
		if (!violations.isEmpty()) throw new BadRequestException(violations);
		else {
			var domain = dataRepository.selectById(request.nip().simple()).orElse(null);
			if (domain == null) {
				domain = WebUserDataMapper.toDomain(request, bCryptPasswordEncoder.encode(defaultPassword));
				domain = dataRepository.create(domain, actionAt, actionBy);
				return WebUserDataMapper.toDetailResponse(domain);
			}

			if (domain.isDeleted()) {
				domain = dataRepository.restore(domain, actionAt, actionBy);
				return WebUserDataMapper.toDetailResponse(domain);
			} else {
				throw new BadRequestException(Map.of("nip", List.of("sudah digunakan")));
			}
		}
	}

}