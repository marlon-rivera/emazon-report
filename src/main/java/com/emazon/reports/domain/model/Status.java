package com.emazon.reports.domain.model;

import java.time.LocalDateTime;

public class Status {

    private String status;
    private LocalDateTime date;

    public Status(String status, LocalDateTime date) {
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
