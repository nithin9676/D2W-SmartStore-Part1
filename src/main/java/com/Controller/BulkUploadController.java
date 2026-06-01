package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.DTO.UploadSummaryDTO;
import com.Service.BulkUploadService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class BulkUploadController {

    @Autowired
    private BulkUploadService bulkUploadService;

    @PostMapping("/bulk-upload/vehicles")
    public UploadSummaryDTO
    uploadVehiclesCSV(

            @RequestParam("file")
            MultipartFile file) {

        return bulkUploadService
                .uploadVehicleVariants(file);
    }
}