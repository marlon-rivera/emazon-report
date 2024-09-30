package com.emazon.reports.adapters.driving.http.controller;

import com.emazon.reports.domain.api.IReportServicePort;
import com.emazon.reports.domain.model.Verification;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final IReportServicePort reportService;

    @PostMapping("/")
    public ResponseEntity<Void> createReport(){
        reportService.saveReport();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateReport(@RequestBody String statusReport){
        reportService.updateStatusReport(statusReport);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addVerification")
    public ResponseEntity<Void> addVerification(@RequestBody Verification verification){
        reportService.addVerification(verification);
        return ResponseEntity.ok().build();
    }

}
