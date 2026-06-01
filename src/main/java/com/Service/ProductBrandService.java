package com.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Entity.ProductBrand;
import com.Repostory.ProductBrandRepository;

@Service
public class ProductBrandService {

    @Autowired
    private ProductBrandRepository productBrandRepository;

    public String insertBrandDetails(ProductBrand productBrand) {

        if(productBrand == null || productBrand.getBrandName() == null || productBrand.getBrandName().trim().isEmpty()) {
            return "brand name is required";
        }

        String brandName = productBrand.getBrandName().trim();

        Optional<ProductBrand> existingBrand = productBrandRepository.findByBrandNameIgnoreCase(brandName);

        if(existingBrand.isPresent()) {
            return "brand already exists";
        }

        productBrand.setBrandName(brandName);

        productBrandRepository.save(productBrand);

        return "brand details saved successfully";
    }

    public Optional<ProductBrand> findByBrandName(String name) {

        if(name == null || name.trim().isEmpty()) {
            return Optional.empty();
        }

        return productBrandRepository.findByBrandNameIgnoreCase(name.trim());
    }

    public String bulkUploadBrands(MultipartFile file) {

        int totalRows = 0;
        int inserted = 0;
        int skipped = 0;

        if(file == null || file.isEmpty()) {
            return "file is required";
        }

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));

            String line;

            reader.readLine();

            while((line = reader.readLine()) != null) {

                totalRows++;

                line = line.trim();

                if(line.isEmpty()) {
                    skipped++;
                    continue;
                }

                String[] data = line.split(",");

                if(data.length < 1) {
                    skipped++;
                    continue;
                }

                String brandName = data[0].trim();

                if(brandName.isEmpty()) {
                    skipped++;
                    continue;
                }

                Optional<ProductBrand> duplicateBrand = productBrandRepository.findByBrandNameIgnoreCase(brandName);

                if(duplicateBrand.isPresent()) {
                    skipped++;
                    continue;
                }

                ProductBrand brand = new ProductBrand();

                brand.setBrandName(brandName);

                productBrandRepository.save(brand);

                inserted++;
            }

        } catch (Exception e) {

            return "error : " + e.getMessage();
        }

        return "total rows : " + totalRows + ", inserted : " + inserted + ", skipped : " + skipped;
    }

    public List<ProductBrand> getAllBrands() {

        return productBrandRepository.findAll();
    }
}