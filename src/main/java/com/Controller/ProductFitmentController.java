package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.DTO.ProductSearchResponseDTO;
import com.Entity.ProductFitment;
import com.Service.ProductFitmentService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class ProductFitmentController {

    @Autowired
    private ProductFitmentService productFitmentService;

    @PostMapping("/product-fitment")
    public String insertProductFitment( @RequestBody ProductFitment productFitment)
    {

        return productFitmentService
                .insertProductFitment(productFitment);
    }

    @GetMapping("/product-fitments")
    public List<ProductFitment> getAllFitments()
    {

        return productFitmentService
                .getAllProductFitments();
    }

    @GetMapping("/fitment/products")
    public List<ProductSearchResponseDTO> getProductsByVariant(
            @RequestParam("variantId") Long variantId)
    {

        return productFitmentService
                .getProductsByVariant(variantId);
    }

    @GetMapping("/fitment/search")
    public List<ProductSearchResponseDTO> smartSearch(
            @RequestParam("variantId") Long variantId,
            @RequestParam(value = "text", required = false) String text)
    {

        return productFitmentService
                .smartSearch(variantId, text);
    }

    @PostMapping("/fitment/bulk-upload")
    public String bulkUpload(
            @RequestParam("file") MultipartFile file)
    {

        return productFitmentService
                .bulkUpload(file);
    }
}