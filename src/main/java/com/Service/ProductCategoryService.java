package com.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Entity.ProductCategory;
import com.Repostory.ProductCategoryRepository;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    /* ================= INSERT CATEGORY ================= */

    public String insertCategoryDetails(ProductCategory category) {

        if (category == null ||
                category.getCategoryName() == null ||
                category.getCategoryName().trim().isEmpty()) {

            return "category name is required";
        }

        String categoryName = category.getCategoryName().trim();

        category.setCategoryName(categoryName);

        Optional<ProductCategory> existingCategory =
                productCategoryRepository
                .findByCategoryNameIgnoreCase(categoryName);

        if (existingCategory.isPresent()) {
            return "category already exists";
        }

        productCategoryRepository.save(category);

        return "category details saved successfully";
    }

    /* ================= FIND CATEGORY ================= */

    public Optional<ProductCategory> findByCategoryName(String name) {

        if (name == null || name.trim().isEmpty()) {
            return Optional.empty();
        }

        return productCategoryRepository
                .findByCategoryNameIgnoreCase(name.trim());
    }

    /* ================= BULK CSV UPLOAD ================= */

    public String uploadBulkCategoryCSV(MultipartFile file) {

        int totalRows = 0;
        int inserted = 0;
        int skipped = 0;

        if (file == null || file.isEmpty()) {
            return "file is required";
        }

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(file.getInputStream()));

            String line;

            /* skip header */
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                totalRows++;

                line = line.trim();

                if (line.isEmpty()) {
                    skipped++;
                    continue;
                }

                String[] data = line.split(",");

                if (data.length < 1) {
                    skipped++;
                    continue;
                }

                String categoryName = data[0].trim();

                if (categoryName.isEmpty()) {
                    skipped++;
                    continue;
                }

                Optional<ProductCategory> existingCategory =
                        productCategoryRepository
                        .findByCategoryNameIgnoreCase(categoryName);

                if (existingCategory.isPresent()) {
                    skipped++;
                    continue;
                }

                ProductCategory category = new ProductCategory();

                category.setCategoryName(categoryName);

                productCategoryRepository.save(category);

                inserted++;
            }

        } catch (Exception e) {

            return "error : " + e.getMessage();
        }

        return "total rows : " + totalRows +
                ", inserted : " + inserted +
                ", skipped : " + skipped;
    }

    /* ================= GET ALL ================= */

    public List<ProductCategory> getAllCategories() {

        return productCategoryRepository.findAll();
    }

}