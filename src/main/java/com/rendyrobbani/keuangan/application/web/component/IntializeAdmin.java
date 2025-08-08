package com.rendyrobbani.keuangan.application.web.component;

import com.rendyrobbani.keuangan.application.core.factory.user.DataUserFactory;
import com.rendyrobbani.keuangan.common.vo.Pangkat;
import com.rendyrobbani.keuangan.common.vo.nip.NipFactory;
import com.rendyrobbani.keuangan.domain.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.repository.user.DataUserRepository;
import com.rendyrobbani.keuangan.domain.repository.user.LogsUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class IntializeAdmin {

	private static final String ADMIN_ID = "199510172019031003";

	private static final Pangkat ADMIN_PANGKAT = Pangkat.PNS_2C;

	private static final String ADMIN_NAME = "Rendy Robbani";

	private static final String ADMIN_TITLE_PREFIX = null;

	private static final String ADMIN_TITLE_SUFFIX = "A.Md.";

	private static final String ADMIN_PASSWORD = "$2a$12$vrC9MirbIo.oGunJ1OYrvebmTLQBkFQcQGzpXy5av8lTfyyED242W";

	private final DataUserRepository dataRepository;

	private final LogsUserRepository logsRepository;

	public IntializeAdmin(DataUserRepository dataRepository, LogsUserRepository logsRepository) {
		this.dataRepository = dataRepository;
		this.logsRepository = logsRepository;
	}

	@Bean
	public DataUser admin() {
		var data = dataRepository.findById(ADMIN_ID).orElse(null);
		if (data == null) {
			var now = LocalDateTime.now();
			var nip = NipFactory.parse(ADMIN_ID);

			data = DataUserFactory.create(now, nip, nip);
			data.setPangkat(ADMIN_PANGKAT);
			data.setName(ADMIN_NAME);
			data.setTitlePrefix(ADMIN_TITLE_PREFIX);
			data.setTitleSuffix(ADMIN_TITLE_SUFFIX);
			data.setPassword(ADMIN_PASSWORD);
			dataRepository.save(data);
			logsRepository.save(data.toLog(now, nip));
		}
		return data;
	}

}