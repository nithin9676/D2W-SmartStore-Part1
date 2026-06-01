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

import com.Entity.ProductBrand;
import com.Service.ProductBrandService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/brands")
public class ProductBrandController {

    @Autowired
    private ProductBrandService productBrandService;

    @PostMapping
    public String insertBrand(@RequestBody ProductBrand brand) {

        return productBrandService.insertBrandDetails(brand);
    }

    @GetMapping("/search")
    public Optional<ProductBrand> findBrandByName(@RequestParam("name") String name) {

        return productBrandService.findByBrandName(name);
    }

    @PostMapping("/bulk-upload")
    public String bulkUpload(@RequestParam("file") MultipartFile file) {

        return productBrandService.bulkUploadBrands(file);
    }

    @GetMapping
    public List<ProductBrand> getAllBrands() {

        return productBrandService.getAllBrands();
    }
}