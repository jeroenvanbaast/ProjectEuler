package com.openvalue.roofingservice.controller;

import com.openvalue.roofingservice.model.Report;
import com.openvalue.roofingservice.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "api/report")
public class ReportController {
    Logger logger = LoggerFactory.getLogger(ReportController.class);
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PutMapping
    public ResponseEntity<Report> updateReport(@RequestBody Report report) {
        if (report.getCustomerName() != null && !report.getCustomerName().isEmpty()) {
            return ResponseEntity.ok(reportService.createReport(report));
        } else {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "CustomerName required");
        }
    }

    @GetMapping("/name")
    public ResponseEntity<List<Report>> getReportsByName(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok(reportService.getByCustomerName(name));
    }

    @GetMapping("/pdf")
    public ResponseEntity<InputStreamResource> getAsPDF(@RequestParam(value = "id") String id) {
        try {
            File pdf = reportService.generatePDF(id);
            InputStreamResource resource = new InputStreamResource(new FileInputStream(pdf));
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + pdf.getName())
                    .contentType(MediaType.APPLICATION_PDF)
                    .contentLength(pdf.length())
                    .body(resource);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "unable to generate PDF", e);
        }
    }

    @PostMapping("/img")
    public ResponseEntity<String> uploadImage(@RequestBody MultipartFile file, @RequestParam(value = "id") String id,
                                              @RequestParam(value = "filepath") String filePath) throws IOException {
        Report report = reportService.getById(id);
        if (report == null) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("No report found");
        }
        File f = new File(filePath);
        f.getParentFile().mkdirs();
        file.transferTo(f.getAbsoluteFile());
        report.setLogoSrc(filePath);
        reportService.createReport(report);
        return ResponseEntity.ok("");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Report>> getAll() {
        return ResponseEntity.ok().body(reportService.getAll());
    }

    @GetMapping("/id")
    public ResponseEntity<Report> getById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok().body(reportService.getById(id));
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam(value = "id") String id) {
        reportService.delete(id);
        return ResponseEntity.ok("");
    }

    @GetMapping("/new")
    public ResponseEntity<Report> getNewReport() {
        return ResponseEntity.ok().body(reportService.createReport(new Report()));
    }
}
