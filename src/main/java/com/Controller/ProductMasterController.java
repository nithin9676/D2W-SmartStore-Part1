package com.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Entity.ProductMaster;
import com.Service.ProductMasterService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/product-masters")
public class ProductMasterController {

    @Autowired
    private ProductMasterService productMasterService;

    @PostMapping
    public String insertProductMaster(@RequestBody ProductMaster productMaster) {

        return productMasterService.insertProductMasterDetails(productMaster);
    }

    @GetMapping("/search")
    public Optional<ProductMaster> findByMasterNameAndCategory(@RequestParam("name") String name,
                                                               @RequestParam("categoryId") Long categoryId) {

        return productMasterService.findByMasterNameAndCategoryId(name, categoryId);
    }

    @PostMapping("/bulk-upload")
    public String bulkUpload(@RequestParam("file") MultipartFile file) {

        return productMasterService.bulkUploadProductMasters(file);
    }

    @GetMapping
    public List<ProductMaster> getAllProductMasters() {

        return productMasterService.getAllProductMasters();
    }
}