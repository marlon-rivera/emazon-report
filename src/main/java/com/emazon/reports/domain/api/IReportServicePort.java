package com.emazon.reports.domain.api;

import com.emazon.reports.domain.model.Report;
import com.emazon.reports.domain.model.Verification;

import java.math.BigDecimal;

public interface IReportServicePort {

    void saveReport();
    void updateStatusReport(String status);
    void addVerification(Verification verification);

}
