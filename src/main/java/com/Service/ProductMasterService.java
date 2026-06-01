package com.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Entity.ProductCategory;
import com.Entity.ProductMaster;
import com.Repostory.ProductCategoryRepository;
import com.Repostory.ProductMasterRepository;

@Service
public class ProductMasterService {

    @Autowired
    private ProductMasterRepository productMasterRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public String insertProductMasterDetails(ProductMaster productMaster) {

        if(productMaster == null || productMaster.getMasterName() == null || productMaster.getMasterName().trim().isBlank()) {
            return "product master name is required";
        }

        String masterName = productMaster.getMasterName().trim();

        productMaster.setMasterName(masterName);

        if(productMaster.getCategory() == null || productMaster.getCategory().getId() == null) {
            return "category id is required";
        }

        Optional<ProductCategory> categoryOptional =
                productCategoryRepository.findById(productMaster.getCategory().getId());

        if(categoryOptional.isEmpty()) {
            return "category not found";
        }

        ProductCategory category = categoryOptional.get();

        Optional<ProductMaster> existing =
                productMasterRepository.findByMasterNameAndCategory_Id(masterName, category.getId());

        if(existing.isPresent()) {
            return "product master already exists in this category";
        }

        productMaster.setCategory(category);

        productMasterRepository.save(productMaster);

        return "product master saved successfully";
    }

    public Optional<ProductMaster> findByMasterNameAndCategoryId(String name, Long categoryId) {

        if(name == null || name.trim().isBlank() || categoryId == null) {
            return Optional.empty();
        }

        return productMasterRepository.findByMasterNameAndCategory_Id(name.trim(), categoryId);
    }

    public String bulkUploadProductMasters(
            MultipartFile file) {

        int totalRows = 0;
        int inserted = 0;
        int skipped = 0;

        if (file == null || file.isEmpty()) {
            return "file is required";
        }

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    file.getInputStream()));

            String line;

            /*
             * Skip Header
             */
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                totalRows++;

                try {

                    line = line.trim();

                    if (line.isEmpty()) {
                        skipped++;
                        continue;
                    }

                    String[] data =
                            line.split(",");

                    if (data.length < 6) {
                        skipped++;
                        continue;
                    }

                    String masterName =
                            data[0].trim();

                    String slug =
                            data[1].trim();

                    String description =
                            data[2].trim();

                    String categoryName =
                            data[3].trim();

                    Boolean isActive =
                            Boolean.parseBoolean(
                                    data[4].trim());

                    Boolean featured =
                            Boolean.parseBoolean(
                                    data[5].trim());

                    /*
                     * Find Category
                     */
                    Optional<ProductCategory>
                            existingCategory =
                            productCategoryRepository
                                    .findByCategoryNameIgnoreCase(
                                            categoryName);

                    if (existingCategory.isEmpty()) {

                        skipped++;
                        continue;
                    }

                    ProductCategory category =
                            existingCategory.get();

                    /*
                     * Check Existing Master
                     */
                    Optional<ProductMaster>
                            existingMaster =
                            productMasterRepository
                                    .findByMasterNameAndCategory_Id(
                                            masterName,
                                            category.getId());

                    if (existingMaster.isPresent()) {

                        skipped++;
                        continue;
                    }

                    /*
                     * Save Product Master
                     */
                    ProductMaster productMaster =
                            new ProductMaster();

                    productMaster.setMasterName(
                            masterName);

                    productMaster.setSlug(
                            slug);

                    productMaster.setDescription(
                            description);

                    productMaster.setCategory(
                            category);

                    productMaster.setIsActive(
                            isActive);

                    productMaster.setFeatured(
                            featured);

                    productMasterRepository
                            .save(productMaster);

                    inserted++;

                } catch (Exception e) {

                    e.printStackTrace();

                    skipped++;
                }
            }

        } catch (Exception e) {

            return "error : " + e.getMessage();
        }

        return "total rows : "
                + totalRows
                + ", inserted : "
                + inserted
                + ", skipped : "
                + skipped;
    }
    public Optional<ProductMaster> findByProductMasterName(String name) {

        if(name == null || name.trim().isBlank()) {
            return Optional.empty();
        }

        return productMasterRepository.findByMasterNameIgnoreCase(name.trim());
    }

    public List<ProductMaster> getAllProductMasters() {

        return productMasterRepository.findAll();
    }
}