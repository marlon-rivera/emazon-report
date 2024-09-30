package com.emazon.reports.domain.api.usecase;

import com.emazon.reports.domain.api.IReportServicePort;
import com.emazon.reports.domain.model.Report;
import com.emazon.reports.domain.model.Status;
import com.emazon.reports.domain.model.Verification;
import com.emazon.reports.domain.spi.IAuthenticationPort;
import com.emazon.reports.domain.spi.IReportPersistencePort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
public class ReportUseCaseImpl implements IReportServicePort {

    private final IReportPersistencePort reportPersistencePort;
    private final IAuthenticationPort authenticationPort;

    @Override
    public void saveReport() {
        Report report = new Report(authenticationPort.getCurrentEmail());
        reportPersistencePort.saveReport(report);
    }

    @Override
    public void updateStatusReport(String status) {
        Optional<Report> reportOptional = reportPersistencePort.getLastReport(authenticationPort.getCurrentEmail());
        Report report = reportOptional.orElseThrow();
        report.addNewStatus(report.getStatusActual());
        report.setStatusActual(new Status(status, LocalDateTime.now()));
        reportPersistencePort.saveReport(report);
    }

    @Override
    public void addVerification(Verification verification) {
        Optional<Report> reportOptional = reportPersistencePort.getLastReport(authenticationPort.getCurrentEmail());
        Report report = reportOptional.orElseThrow();
        report.getVerifications().add(verification);
        reportPersistencePort.saveReport(report);
    }
}
