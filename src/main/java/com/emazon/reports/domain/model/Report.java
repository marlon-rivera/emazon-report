package com.emazon.reports.domain.model;

import com.emazon.reports.utils.Constants;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Report {

    private String id;
    private String email;
    private Status statusActual;
    private LocalDateTime purchaseDate;
    private List<Status> previousStatus;
    private List<Verification> verifications;
    private BigDecimal totalPrice;

    public Report(String email) {
        this.email = email;
        purchaseDate = LocalDateTime.now();
        statusActual = new Status(Constants.STATUS_START, LocalDateTime.now());
        previousStatus = new ArrayList<>();
        verifications = new ArrayList<>();
    }

    public void addNewVerification(Verification verification) {
        verifications.add(verification);
    }

    public void addNewStatus(Status status) {
        previousStatus.add(status);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatusActual() {
        return statusActual;
    }

    public void setStatusActual(Status statusActual) {
        this.statusActual = statusActual;
    }

    public List<Status> getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(List<Status> previousStatus) {
        this.previousStatus = previousStatus;
    }

    public List<Verification> getVerifications() {
        return verifications;
    }

    public void setVerifications(List<Verification> verifications) {
        this.verifications = verifications;
    }

    public BigDecimal getTotalPrice() {return totalPrice;}

    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }

    public LocalDateTime getPurchaseDate() {return purchaseDate;}

    public void setPurchaseDate(LocalDateTime purchaseDate) { this.purchaseDate = purchaseDate; }
}

