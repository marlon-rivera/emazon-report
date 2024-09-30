package com.emazon.reports.adapters.driven.mongo.adapter;

import com.emazon.reports.adapters.driven.mongo.mapper.IReportDocumentMapper;
import com.emazon.reports.adapters.driven.mongo.repository.IReportRepository;
import com.emazon.reports.domain.model.Report;
import com.emazon.reports.domain.model.Verification;
import com.emazon.reports.domain.spi.IReportPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ReportAdapter implements IReportPersistencePort {

    private final IReportDocumentMapper reportDocumentMapper;
    private final IReportRepository reportRepository;

    @Override
    public void saveReport(Report report) {
        reportRepository.save(reportDocumentMapper.toReportDocument(report));
    }

    @Override
    public void updateStatusReport(Report report) {

    }

    @Override
    public Optional<Report> getLastReport(String email) {
        return reportDocumentMapper.toOptionalReport(reportRepository.findFirstByEmailOrderByPurchaseDateDesc(email));
    }
}
