package com.rendyrobbani.keuangan.infrastructure.config;

import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.model.entity.user.DataUserRecord;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.model.vo.NipFactory;
import com.rendyrobbani.keuangan.domain.model.vo.Pangkat;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.LogsUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class WebAdminConfig {

	public static final Nip ADMIN_NIP = NipFactory.create("199510172019031003");

	public static final Pangkat ADMIN_PANGKAT = Pangkat.PNS_2C;

	public static final String ADMIN_NAME = "Rendy Robbani";

	public static final String ADMIN_TITLE_PREFIX = null;

	public static final String ADMIN_TITLE_SUFFIX = "A.Md.";

	public static final String ADMIN_PASSWORD = "$2a$12$tw0qm9oRGF0ocsuzdXpwM.4mVolzc7YmZrqwQO7TkiMKTHZgPMLrC";

	private final DataUserRepository dataRepository;

	private final LogsUserRepository logsRepository;

	public WebAdminConfig(DataUserRepository dataRepository, LogsUserRepository logsRepository) {
		this.dataRepository = dataRepository;
		this.logsRepository = logsRepository;
	}

	@Bean
	public DataUser admin() {
		var now = LocalDateTime.now();
		var nip = ADMIN_NIP;

		var data = dataRepository.selectById(nip.simple()).orElse(null);
		if (data == null) {
			data = new DataUserRecord(ADMIN_NIP.simple(),
			                          ADMIN_NIP,
			                          ADMIN_PANGKAT,
			                          ADMIN_NAME,
			                          ADMIN_TITLE_PREFIX,
			                          ADMIN_TITLE_SUFFIX,
			                          ADMIN_PASSWORD,
			                          ADMIN_NIP.dateOfBirth(),
			                          ADMIN_NIP.dateOfStart(),
			                          ADMIN_NIP.gender(),
			                          ADMIN_NIP.number(),
			                          ADMIN_PANGKAT.isPNS(),
			                          ADMIN_PANGKAT.isP3K(),
			                          false,
			                          false);
			dataRepository.create(data, now, nip);
			logsRepository.create(data.toLog(), now, nip);
		}
		return data;
	}

}