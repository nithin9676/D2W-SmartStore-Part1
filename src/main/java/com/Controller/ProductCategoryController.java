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

import com.Entity.ProductCategory;
import com.Service.ProductCategoryService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/categories")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping
    public String insertCategory(@RequestBody ProductCategory category) {

        return productCategoryService.insertCategoryDetails(category);
    }

    @GetMapping("/search")
    public Optional<ProductCategory> findCategoryByName(@RequestParam("name") String name) {

        return productCategoryService.findByCategoryName(name);
    }

    @PostMapping("/bulk-upload")
    public String bulkUpload(@RequestParam("file") MultipartFile file) {

        return productCategoryService.uploadBulkCategoryCSV(file);
    }

    @GetMapping
    public List<ProductCategory> getAllCategories() {

        return productCategoryService.getAllCategories();
    }
}