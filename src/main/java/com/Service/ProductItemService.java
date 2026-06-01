package com.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.DTO.ProductDetailResponseDTO;
import com.DTO.ProductSearchResponseDTO;
import com.Entity.ProductBrand;
import com.Entity.ProductFitment;
import com.Entity.ProductItem;
import com.Entity.ProductMaster;
import com.Entity.VehicleVariant;
import com.Repostory.ProductBrandRepository;
import com.Repostory.ProductFitmentRepository;
import com.Repostory.ProductItemRepository;
import com.Repostory.ProductMasterRepository;
import com.enumclasses.ApprovalStatus;
import com.enumclasses.FittingPosition;
import com.enumclasses.OriginType;
import com.enumclasses.StockStatus;

@Service
public class ProductItemService {

    @Autowired
    private ProductItemRepository productItemRepository;

    @Autowired
    private ProductMasterRepository productMasterRepository;

    @Autowired
    private ProductBrandRepository productBrandRepository;

    @Autowired
    private ProductFitmentRepository productFitmentRepository;

    public String insertProductItemDetails(ProductItem productItem) {

        if(productItem == null || productItem.getItemName() == null || productItem.getItemName().trim().isBlank()) {
            return "product item name is required";
        }

        if(productItem.getPartNumber() == null || productItem.getPartNumber().trim().isBlank()) {
            return "part number is required";
        }

        if(productItem.getSku() == null || productItem.getSku().trim().isBlank()) {
            return "sku is required";
        }

        String itemName = productItem.getItemName().trim();
        String partNumber = productItem.getPartNumber().trim();
        String sku = productItem.getSku().trim();

        productItem.setItemName(itemName);
        productItem.setPartNumber(partNumber);
        productItem.setSku(sku);

        if(productItem.getPartMaster() == null || productItem.getPartMaster().getId() == null) {
            return "product master id is required";
        }

        if(productItem.getPartBrand() == null || productItem.getPartBrand().getId() == null) {
            return "product brand id is required";
        }

        Optional<ProductMaster> masterOptional = productMasterRepository.findById(productItem.getPartMaster().getId());

        if(masterOptional.isEmpty()) {
            return "product master not found";
        }

        Optional<ProductBrand> brandOptional = productBrandRepository.findById(productItem.getPartBrand().getId());

        if(brandOptional.isEmpty()) {
            return "product brand not found";
        }

        Optional<ProductItem> existingProduct = productItemRepository.findByPartNumberIgnoreCase(partNumber);

        if(existingProduct.isPresent()) {
            return "part number already exists";
        }

        productItem.setPartMaster(masterOptional.get());
        productItem.setPartBrand(brandOptional.get());

        productItemRepository.save(productItem);

        return "product item saved successfully";
    }

    public List<ProductItem> getAllProductItems() {

        return productItemRepository.findAll();
    }

    public Optional<ProductItem> getItemByPartNumber(String number) {

        if(number == null || number.trim().isBlank()) {
            return Optional.empty();
        }

        return productItemRepository.findByPartNumberIgnoreCase(number.trim());
    }

    public List<ProductItem> getByMasterId(Long masterId) {

        return productItemRepository.findByPartMaster_Id(masterId);
    }

    public String bulkUpload(
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
             * Skip CSV Header
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

                    /*
                     * Expected Columns = 28
                     */
                    if (data.length < 28) {

                        skipped++;
                        continue;
                    }

                    /*
                     * =========================
                     * BASIC INFO
                     * =========================
                     */

                    String itemName =
                            data[0].trim();

                    String slug =
                            data[1].trim();

                    String description =
                            data[2].trim();

                    String partNumber =
                            data[3].trim();

                    String alternatePartNumber =
                            data[4].trim();

                    String oemNumber =
                            data[5].trim();

                    String hsnCode =
                            data[6].trim();

                    String sku =
                            data[7].trim();

                    /*
                     * =========================
                     * RELATIONSHIP DATA
                     * =========================
                     */

                    String masterName =
                            data[8].trim();

                    String brandName =
                            data[9].trim();

                    /*
                     * =========================
                     * PRICING
                     * =========================
                     */

                    BigDecimal mrpPrice =
                            new BigDecimal(
                                    data[10].trim());

                    BigDecimal sellingPrice =
                            new BigDecimal(
                                    data[11].trim());

                    BigDecimal costPrice =
                            new BigDecimal(
                                    data[12].trim());

                    BigDecimal discountPercentage =
                            new BigDecimal(
                                    data[13].trim());

                    BigDecimal gstPercentage =
                            new BigDecimal(
                                    data[14].trim());

                    /*
                     * =========================
                     * INVENTORY
                     * =========================
                     */

                    Integer stockQuantity =
                            Integer.parseInt(
                                    data[15].trim());

                    StockStatus stockStatus =
                            StockStatus.valueOf(
                                    data[16].trim());

                    /*
                     * =========================
                     * APPROVAL
                     * =========================
                     */

                    ApprovalStatus approvalStatus =
                            ApprovalStatus.valueOf(
                                    data[17].trim());

                    /*
                     * =========================
                     * ORIGIN
                     * =========================
                     */

                    OriginType originType =
                            OriginType.valueOf(
                                    data[18].trim());

                    /*
                     * =========================
                     * IMAGES
                     * =========================
                     */

                    String mainImageUrl =
                            data[19].trim();

                    String secondaryImageUrl =
                            data[20].trim();

                    String thirdImageUrl =
                            data[21].trim();

                    /*
                     * =========================
                     * MANUFACTURER
                     * =========================
                     */

                    String manufacturer =
                            data[22].trim();

                    String countryOfOrigin =
                            data[23].trim();

                    /*
                     * =========================
                     * FITTING POSITION
                     * =========================
                     */

                    FittingPosition fittingPosition =
                            FittingPosition.valueOf(
                                    data[24].trim());

                    /*
                     * =========================
                     * SEO
                     * =========================
                     */

                    String metaTitle =
                            data[25].trim();

                    String metaDescription =
                            data[26].trim();

                    /*
                     * =========================
                     * STATUS
                     * =========================
                     */

                    Boolean isActive =
                            Boolean.parseBoolean(
                                    data[27].trim());

                    /*
                     * =========================
                     * VALIDATION
                     * =========================
                     */

                    if (
                            itemName.isBlank()
                            || slug.isBlank()
                            || partNumber.isBlank()
                            || sku.isBlank()
                            || masterName.isBlank()
                            || brandName.isBlank()
                    ) {

                        skipped++;
                        continue;
                    }

                    /*
                     * =========================
                     * FIND PRODUCT MASTER
                     * =========================
                     */

                    Optional<ProductMaster>
                            masterOptional =
                            productMasterRepository
                                    .findByMasterNameIgnoreCase(
                                            masterName);

                    if (masterOptional.isEmpty()) {

                        skipped++;
                        continue;
                    }

                    /*
                     * =========================
                     * FIND PRODUCT BRAND
                     * =========================
                     */

                    Optional<ProductBrand>
                            brandOptional =
                            productBrandRepository
                                    .findByBrandNameIgnoreCase(
                                            brandName);

                    if (brandOptional.isEmpty()) {

                        skipped++;
                        continue;
                    }

                    /*
                     * =========================
                     * DUPLICATE CHECK
                     * =========================
                     */

                    Optional<ProductItem>
                            existingProduct =
                            productItemRepository
                                    .findByPartNumberIgnoreCase(
                                            partNumber);

                    if (existingProduct.isPresent()) {

                        skipped++;
                        continue;
                    }

                    /*
                     * =========================
                     * CREATE PRODUCT ITEM
                     * =========================
                     */

                    ProductItem productItem =
                            new ProductItem();

                    productItem.setItemName(
                            itemName);

                    productItem.setSlug(
                            slug);

                    productItem.setDescription(
                            description);

                    productItem.setPartNumber(
                            partNumber);

                    productItem.setAlternatePartNumber(
                            alternatePartNumber);

                    productItem.setOemNumber(
                            oemNumber);

                    productItem.setHsnCode(
                            hsnCode);

                    productItem.setSku(
                            sku);

                    productItem.setPartMaster(
                            masterOptional.get());

                    productItem.setPartBrand(
                            brandOptional.get());

                    productItem.setMrpPrice(
                            mrpPrice);

                    productItem.setSellingPrice(
                            sellingPrice);

                    productItem.setCostPrice(
                            costPrice);

                    productItem.setDiscountPercentage(
                            discountPercentage);

                    productItem.setGstPercentage(
                            gstPercentage);

                    productItem.setStockQuantity(
                            stockQuantity);

                    productItem.setStockStatus(
                            stockStatus);

                    productItem.setApprovalStatus(
                            approvalStatus);

                    productItem.setOriginType(
                            originType);

                    productItem.setMainImageUrl(
                            mainImageUrl);

                    productItem.setSecondaryImageUrl(
                            secondaryImageUrl);

                    productItem.setThirdImageUrl(
                            thirdImageUrl);

                    productItem.setManufacturer(
                            manufacturer);

                    productItem.setCountryOfOrigin(
                            countryOfOrigin);

                    productItem.setFittingPosition(
                            fittingPosition);

                    productItem.setMetaTitle(
                            metaTitle);

                    productItem.setMetaDescription(
                            metaDescription);

                    productItem.setIsActive(
                            isActive);

                    /*
                     * =========================
                     * SAVE
                     * =========================
                     */

                    productItemRepository
                            .save(productItem);

                    inserted++;

                } catch (Exception e) {

                    e.printStackTrace();

                    skipped++;
                }
            }

        } catch (Exception e) {

            return "error : "
                    + e.getMessage();
        }

        return "total rows : "
                + totalRows
                + ", inserted : "
                + inserted
                + ", skipped : "
                + skipped;
    }

    public List<ProductSearchResponseDTO> getProductBySearchText(String text) {

        List<ProductSearchResponseDTO> result = new ArrayList<>();

        List<ProductItem> allProducts;

        if(text == null || text.trim().isBlank()) {

            allProducts = productItemRepository.findAll();

        } else {

            allProducts = productItemRepository.globalSearchProducts(text.trim());
        }

        for(ProductItem productItem : allProducts) {

            ProductSearchResponseDTO dto = new ProductSearchResponseDTO();

            dto.setId(productItem.getId());

            dto.setItemName(productItem.getItemName());

            dto.setSlug(productItem.getSlug());

            dto.setPartNumber(productItem.getPartNumber());

            dto.setBrandName(productItem.getPartBrand().getBrandName());

            dto.setCategoryName(productItem.getPartMaster().getCategory().getCategoryName());

            dto.setPartName(productItem.getPartMaster().getMasterName());

            dto.setMainImageUrl(productItem.getMainImageUrl());

            dto.setSellingPrice(productItem.getSellingPrice());

            dto.setInStock(productItem.getStockQuantity() != null && productItem.getStockQuantity() > 0);

            result.add(dto);
        }

        return result;
    }

  
    public ProductItem getProductById(Long id)
    {

        return productItemRepository
                .findById(id)
                .orElse(null);
    }
    public ProductDetailResponseDTO getProductDetails(Long id) {

        Optional<ProductItem> optional = productItemRepository.findById(id);

        if(optional.isEmpty()) {
            return null;
        }

        ProductItem productItem = optional.get();

        ProductDetailResponseDTO dto = new ProductDetailResponseDTO();

        dto.setId(productItem.getId());
        dto.setItemName(productItem.getItemName());
        dto.setSlug(productItem.getSlug());
        dto.setPartNumber(productItem.getPartNumber());
        dto.setAlternatePartNumber(productItem.getAlternatePartNumber());
        dto.setOemNumber(productItem.getOemNumber());
        dto.setHsnCode(productItem.getHsnCode());
        dto.setSku(productItem.getSku());
        dto.setDescription(productItem.getDescription());

        dto.setMrpPrice(productItem.getMrpPrice());
        dto.setSellingPrice(productItem.getSellingPrice());
        dto.setCostPrice(productItem.getCostPrice());
        dto.setDiscountPercentage(productItem.getDiscountPercentage());
        dto.setGstPercentage(productItem.getGstPercentage());

        dto.setManufacturer(productItem.getManufacturer());
        dto.setCountryOfOrigin(productItem.getCountryOfOrigin());

        dto.setStockQuantity(productItem.getStockQuantity());

        if(productItem.getStockStatus() != null) {
            dto.setStockStatus(productItem.getStockStatus().name());
        }

        dto.setInStock(productItem.getStockQuantity() != null && productItem.getStockQuantity() > 0);

        if(productItem.getPartBrand() != null) {
            dto.setBrandName(productItem.getPartBrand().getBrandName());
        }

        if(productItem.getPartMaster() != null) {

            dto.setProductMasterName(productItem.getPartMaster().getMasterName());

            if(productItem.getPartMaster().getCategory() != null) {
                dto.setCategoryName(productItem.getPartMaster().getCategory().getCategoryName());
            }
        }

        List<String> images = new ArrayList<>();

        if(productItem.getMainImageUrl() != null && !productItem.getMainImageUrl().isBlank()) {
            images.add(productItem.getMainImageUrl());
        }

        if(productItem.getSecondaryImageUrl() != null && !productItem.getSecondaryImageUrl().isBlank()) {
            images.add(productItem.getSecondaryImageUrl());
        }

        if(productItem.getThirdImageUrl() != null && !productItem.getThirdImageUrl().isBlank()) {
            images.add(productItem.getThirdImageUrl());
        }

        dto.setImages(images);

        List<String> compatibleVehicles = new ArrayList<>();

        List<ProductFitment> fitments = productFitmentRepository.findByProductItem_Id(productItem.getId());

        for(ProductFitment fitment : fitments) {

            VehicleVariant variant = fitment.getVehicleVariant();

            if(variant == null) {
                continue;
            }

            if(variant.getVehicleGeneration() == null) {
                continue;
            }

            if(variant.getVehicleGeneration().getVehicleModel() == null) {
                continue;
            }

            if(variant.getVehicleGeneration().getVehicleModel().getVehicleMake() == null) {
                continue;
            }

            String vehicleName =
                    variant.getVehicleGeneration().getVehicleModel().getVehicleMake().getMakeName()
                    + " "
                    + variant.getVehicleGeneration().getVehicleModel().getModelName()
                    + " "
                    + variant.getVariantName();

            compatibleVehicles.add(vehicleName);
        }

        dto.setCompatibleVehicles(compatibleVehicles);

        return dto;
    }
}