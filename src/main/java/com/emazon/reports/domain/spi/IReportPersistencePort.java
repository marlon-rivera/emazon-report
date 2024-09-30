package com.emazon.reports.domain.spi;

import com.emazon.reports.domain.model.Report;

import java.util.Optional;

public interface IReportPersistencePort {

    void saveReport(Report report);
    void updateStatusReport(Report report);
    Optional<Report> getLastReport(String email);

}
