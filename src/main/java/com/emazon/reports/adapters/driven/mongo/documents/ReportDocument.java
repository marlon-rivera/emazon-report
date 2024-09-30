package com.emazon.reports.adapters.driven.mongo.documents;

import com.emazon.reports.domain.model.Status;
import com.emazon.reports.domain.model.Verification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "reports")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportDocument {

    @Id
    private String id;
    private String email;
    private LocalDateTime purchaseDate;
    private Status statusActual;
    private List<Status> previousStatus;
    private List<Verification> verifications;
    private BigDecimal totalPrice;

}
