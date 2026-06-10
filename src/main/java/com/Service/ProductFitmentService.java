package com.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.DTO.ProductSearchResponseDTO;
import com.Entity.ProductFitment;
import com.Entity.ProductItem;
import com.Entity.VehicleVariant;
import com.Repostory.ProductFitmentRepository;
import com.Repostory.ProductItemRepository;
import com.Repostory.VehicleVariantRepository;

@Service
public class ProductFitmentService {

    @Autowired
    private ProductFitmentRepository productFitmentRepository;

    @Autowired
    private ProductItemRepository productItemRepository;

    @Autowired
    private VehicleVariantRepository vehicleVariantRepository;

    public String insertProductFitment(ProductFitment productFitment) {

        if(productFitment == null) {
            return "fitment data is required";
        }

        if(productFitment.getProductItem() == null || productFitment.getProductItem().getId() == null) {
            return "product item id is required";
        }

        if(productFitment.getVehicleVariant() == null || productFitment.getVehicleVariant().getId() == null) {
            return "vehicle variant id is required";
        }

        Optional<ProductItem> productOptional =
                productItemRepository.findById(productFitment.getProductItem().getId());

        if(productOptional.isEmpty()) {
            return "product item not found";
        }

        Optional<VehicleVariant> variantOptional =
                vehicleVariantRepository.findById(productFitment.getVehicleVariant().getId());

        if(variantOptional.isEmpty()) {
            return "vehicle variant not found";
        }

        Optional<ProductFitment> duplicateFitment =
                productFitmentRepository.findByProductItem_IdAndVehicleVariant_Id(
                        productFitment.getProductItem().getId(),
                        productFitment.getVehicleVariant().getId());

        if(duplicateFitment.isPresent()) {
            return "fitment already exists";
        }

        productFitment.setProductItem(productOptional.get());

        productFitment.setVehicleVariant(variantOptional.get());

        productFitmentRepository.save(productFitment);

        return "product fitment saved successfully";
    }

    public List<ProductFitment> getAllProductFitments() {

        return productFitmentRepository.findAll();
    }

    public List<ProductSearchResponseDTO>
    getProductsByVariant(Long variantId)
    {

        List<ProductSearchResponseDTO>
                result = new ArrayList<>();

        if(variantId == null)
        {
            return result;
        }

        List<ProductFitment> fitments =
                productFitmentRepository
                        .findByVehicleVariant_Id(
                                variantId
                        );

        for(ProductFitment fitment : fitments)
        {

            ProductItem item =
                    fitment.getProductItem();

            if(item == null)
            {
                continue;
            }

            ProductSearchResponseDTO dto =
                    new ProductSearchResponseDTO();

            dto.setId(item.getId());

            dto.setItemName(
                    item.getItemName()
            );

            dto.setSlug(
                    item.getSlug()
            );

            dto.setPartNumber(
                    item.getPartNumber()
            );

            dto.setMainImageUrl(
                    item.getMainImageUrl()
            );

            dto.setSellingPrice(
                    item.getSellingPrice()
            );

            dto.setInStock(
                    item.getStockQuantity() != null
                    &&
                    item.getStockQuantity() > 0
            );

        

            if(item.getPartBrand() != null)
            {
                dto.setBrandName(
                        item.getPartBrand()
                                .getBrandName()
                );
            }

            if(item.getPartMaster() != null)
            {

                dto.setPartName(
                        item.getPartMaster()
                                .getMasterName()
                );

                if(item.getPartMaster()
                        .getCategory() != null)
                {

                    dto.setCategoryName(
                            item.getPartMaster()
                                    .getCategory()
                                    .getCategoryName()
                    );
                }
            }

            result.add(dto);
        }

        return result;
    }

    public List<ProductSearchResponseDTO> smartSearch(Long variantId, String text) {

        List<ProductSearchResponseDTO> result = new ArrayList<>();

        if(variantId == null) {
            return result;
        }

        String keyword = text == null ? "" : text.trim().toLowerCase();

        List<ProductFitment> fitments =
                productFitmentRepository.findByVehicleVariant_Id(variantId);

        for(ProductFitment fitment : fitments) {

            ProductItem item = fitment.getProductItem();

            if(item == null || item.getPartMaster() == null || item.getPartBrand() == null || item.getPartMaster().getCategory() == null) {
                continue;
            }

            String itemName =
                    item.getItemName() == null ? "" : item.getItemName().toLowerCase();

            String partNumber =
                    item.getPartNumber() == null ? "" : item.getPartNumber().toLowerCase();

            String oemNumber =
                    item.getOemNumber() == null ? "" : item.getOemNumber().toLowerCase();

            String hsnCode =
                    item.getHsnCode() == null ? "" : item.getHsnCode().toLowerCase();

            String sku =
                    item.getSku() == null ? "" : item.getSku().toLowerCase();

            String brandName =
                    item.getPartBrand().getBrandName() == null ? ""
                            : item.getPartBrand().getBrandName().toLowerCase();

            String masterName =
                    item.getPartMaster().getMasterName() == null ? ""
                            : item.getPartMaster().getMasterName().toLowerCase();

            String categoryName =
                    item.getPartMaster().getCategory().getCategoryName() == null ? ""
                            : item.getPartMaster().getCategory().getCategoryName().toLowerCase();

            boolean matches =
                    keyword.isBlank()
                    || itemName.contains(keyword)
                    || partNumber.contains(keyword)
                    || oemNumber.contains(keyword)
                    || hsnCode.contains(keyword)
                    || sku.contains(keyword)
                    || brandName.contains(keyword)
                    || masterName.contains(keyword)
                    || categoryName.contains(keyword);

            if(matches) {

                ProductSearchResponseDTO dto = new ProductSearchResponseDTO();

                dto.setId(item.getId());

                dto.setItemName(item.getItemName());

                dto.setSlug(item.getSlug());

                dto.setPartNumber(item.getPartNumber());

                dto.setBrandName(item.getPartBrand().getBrandName());

                dto.setCategoryName(item.getPartMaster().getCategory().getCategoryName());

                dto.setPartName(item.getPartMaster().getMasterName());

                dto.setMainImageUrl(item.getMainImageUrl());

                dto.setSellingPrice(item.getSellingPrice());

                dto.setInStock(item.getStockQuantity() != null && item.getStockQuantity() > 0);

                result.add(dto);
            }
        }

        return result;
    }

    public String bulkUpload(MultipartFile file) {

        if(file == null || file.isEmpty()) {
            return "file is required";
        }

        int totalRows = 0;
        int inserted = 0;
        int skipped = 0;

        try {

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(file.getInputStream()));

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

                if(data.length < 2) {
                    skipped++;
                    continue;
                }

                String partNumber =
                        data[0].trim().replaceAll("^\"|\"$", "");

                String variantFullName =
                        data[1].trim().replaceAll("^\"|\"$", "");

                if(partNumber.isBlank() || variantFullName.isBlank()) {
                    skipped++;
                    continue;
                }

                Optional<ProductItem> productOptional =
                        productItemRepository.findByPartNumberIgnoreCase(partNumber);

                Optional<VehicleVariant> variantOptional =
                        vehicleVariantRepository.findByFullNameIgnoreCase(variantFullName);

                if(productOptional.isEmpty() || variantOptional.isEmpty()) {
                    skipped++;
                    continue;
                }

                Optional<ProductFitment> duplicateFitment =
                        productFitmentRepository.findByProductItem_IdAndVehicleVariant_Id(
                                productOptional.get().getId(),
                                variantOptional.get().getId());

                if(duplicateFitment.isPresent()) {
                    skipped++;
                    continue;
                }

                ProductFitment fitment = new ProductFitment();

                fitment.setProductItem(productOptional.get());

                fitment.setVehicleVariant(variantOptional.get());

                productFitmentRepository.save(fitment);

                inserted++;
            }

        } catch (Exception e) {

            return "error : " + e.getMessage();
        }

        return "total rows : " + totalRows + ", inserted : " + inserted + ", skipped : " + skipped;
    }
    public List<ProductSearchResponseDTO> getProductsByVariant1(Long variantId)
    {

        if(variantId == null)
        {
            return new ArrayList<>();
        }

        Optional<VehicleVariant> variantOptional =
                vehicleVariantRepository.findById(variantId);

        if(variantOptional.isEmpty())
        {
            return new ArrayList<>();
        }

        return productFitmentRepository.getProductsByVariant(variantId);
    }
}