package com.emazon.reports.adapters.driven.mongo.repository;

import com.emazon.reports.adapters.driven.mongo.documents.ReportDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IReportRepository extends MongoRepository<ReportDocument, String> {

    Optional<ReportDocument> findFirstByEmailOrderByPurchaseDateDesc(String email);

}
