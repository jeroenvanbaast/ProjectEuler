package com.openvalue.roofingservice.controller;

import com.openvalue.roofingservice.model.ImageSource;
import com.openvalue.roofingservice.model.Report;
import com.openvalue.roofingservice.service.JWTService;
import com.openvalue.roofingservice.service.ReportService;
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
    private final ReportService reportService;
    private final JWTService jwtService;

    @Autowired
    public ReportController(ReportService reportService, JWTService jwtService) {
        this.reportService = reportService;
        this.jwtService = jwtService;
    }

    @PutMapping
    public ResponseEntity<Report> updateReport(@RequestBody Report report) {
        return ResponseEntity.ok(reportService.saveReport(report));

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
            ResponseEntity<InputStreamResource> responseEntity = ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + pdf.getName())
                    .contentType(MediaType.APPLICATION_PDF)
                    .contentLength(pdf.length())
                    .body(resource);
            return responseEntity;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "unable to generate PDF, " + e.getMessage(), e);
        }
    }

    /**
     * saves an image to the provided file location, sets the filepath in the correct field
     * in the correct model based on the provided source, and finally saves the report.
     *
     * @param file:          the image to be uploaded
     * @param source:        what the uploaded image is for, it could be a logo for the report, a main image for a roofsurface,
     *                       or one of the images belonging to the roofsurfaces findings.
     * @param filePath:      The filepath generated by the frontend, which specifies where the image should be saved
     * @param reportId:      The id of the report it should be saved in
     * @param roofSurfaceId: The id of the roofsurface the image belongs to, can be null if the image is a report logo.
     * @return returns a ResponseEntity with the status of the request
     */
    @PostMapping("/img")
    public ResponseEntity<Report> uploadImage(@RequestBody MultipartFile file, @RequestParam(value = "source") ImageSource source,
                                              @RequestParam(value = "filepath") String filePath,
                                              @RequestParam(value = "reportid") String reportId,
                                              @RequestParam(value = "roofsurfaceid", required = false) String roofSurfaceId) {
         return reportService.uploadImage(file, source, filePath, reportId, roofSurfaceId);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Report>> getAll(@RequestHeader("AUTHORIZATION") String token) {
        if(jwtService.verifyJWT(token)){
            return ResponseEntity.ok().body(reportService.getAll());
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong with the login");
    }

    @GetMapping("/id")
    public ResponseEntity<Report> getById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok().body(reportService.getById(id));
    }

    /**
     * Deletes the report and all resources related to the report
     * if removing the resources fails, it will throw an internal server error
     *
     * @param id: the report id to be deleted
     * @return a responseEntity with the status of the request
     */
    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam(value = "id") String id) {
        try {
            reportService.delete(id);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "unable to delete report", e);
        }
        return ResponseEntity.ok("");
    }

    @GetMapping("/new")
    public ResponseEntity<Report> getNewReport() {
        return ResponseEntity.ok().body(reportService.saveReport(new Report()));
    }

    /**
     * Removes a roofsurface from a report and all resources belonging to that roofsurfaces
     * if removing the resources fails, it will throw an internal server error
     *
     * @param reportId:      The reportid which the roofsurface belongs to
     * @param roofSurfaceId: the roofsurfaceid to be deleted
     * @return The ResponseEntity with the result of the request
     */
    @PutMapping("/removeroofsurface")
    public ResponseEntity<Report> removeRoofSurface(@RequestParam(value = "reportid") String reportId, @RequestParam(value = "roofsurfaceid") String roofSurfaceId) {
        try {
            return ResponseEntity.ok(reportService.removeRoofSurface(reportId, roofSurfaceId));
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "unable to remove roofsurface", e);
        }

    }
}
