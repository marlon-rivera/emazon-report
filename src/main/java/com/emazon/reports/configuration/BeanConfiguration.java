package com.emazon.reports.configuration;

import com.emazon.reports.adapters.driven.authentication.AuthenticationAdapter;
import com.emazon.reports.adapters.driven.mongo.adapter.ReportAdapter;
import com.emazon.reports.adapters.driven.mongo.mapper.IReportDocumentMapper;
import com.emazon.reports.adapters.driven.mongo.repository.IReportRepository;
import com.emazon.reports.domain.api.IReportServicePort;
import com.emazon.reports.domain.api.usecase.ReportUseCaseImpl;
import com.emazon.reports.domain.spi.IAuthenticationPort;
import com.emazon.reports.domain.spi.IReportPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IReportRepository reportRepository;
    private final IReportDocumentMapper reportDocumentMapper;

    @Bean
    public IReportPersistencePort reportPersistencePort() {
        return new ReportAdapter(reportDocumentMapper, reportRepository);
    }

    @Bean
    public IAuthenticationPort authenticationPort() {
        return new AuthenticationAdapter();
    }

    @Bean
    public IReportServicePort reportServicePort() {
        return new ReportUseCaseImpl(reportPersistencePort(), authenticationPort());
    }

}
