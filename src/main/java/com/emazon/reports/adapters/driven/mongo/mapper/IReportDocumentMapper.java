package com.emazon.reports.adapters.driven.mongo.mapper;

import com.emazon.reports.adapters.driven.mongo.documents.ReportDocument;
import com.emazon.reports.domain.model.Report;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface IReportDocumentMapper {

    Report toReport(ReportDocument reportDocument);

    ReportDocument toReportDocument(Report report);

    default Optional<Report> toOptionalReport(Optional<ReportDocument> reportDocument){
        return reportDocument.map(this::toReport);
    }
}
