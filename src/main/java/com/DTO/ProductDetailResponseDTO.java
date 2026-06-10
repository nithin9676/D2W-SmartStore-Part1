package com.DTO;

import java.math.BigDecimal;
import java.util.List;

public class ProductDetailResponseDTO {

    private Long id;

    private String itemName;

    private String slug;

    private String partNumber;

    private String alternatePartNumber;

    private String oemNumber;

    private String hsnCode;

    private String sku;

    private String brandName;

    private String categoryName;

    private String productMasterName;

    private BigDecimal mrpPrice;

    private BigDecimal sellingPrice;

    private BigDecimal costPrice;

    private BigDecimal discountPercentage;

    private BigDecimal gstPercentage;

    private String description;

    private String manufacturer;

    private String countryOfOrigin;

    private String originType;

    private String stockStatus;

    private Integer stockQuantity;

    private String fittingPosition;

    private Boolean isActive;

    private Boolean inStock;

    private List<String> images;

    private List<VehicleCompatibilityDTO> compatibleVehicles;

    public ProductDetailResponseDTO() {
    }

   

    public ProductDetailResponseDTO(Long id, String itemName, String slug, String partNumber,
			String alternatePartNumber, String oemNumber, String hsnCode, String sku, String brandName,
			String categoryName, String productMasterName, BigDecimal mrpPrice, BigDecimal sellingPrice,
			BigDecimal costPrice, BigDecimal discountPercentage, BigDecimal gstPercentage, String description,
			String manufacturer, String countryOfOrigin, String originType, String stockStatus, Integer stockQuantity,
			String fittingPosition, Boolean isActive, Boolean inStock, List<String> images,
			List<VehicleCompatibilityDTO> compatibleVehicles) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.slug = slug;
		this.partNumber = partNumber;
		this.alternatePartNumber = alternatePartNumber;
		this.oemNumber = oemNumber;
		this.hsnCode = hsnCode;
		this.sku = sku;
		this.brandName = brandName;
		this.categoryName = categoryName;
		this.productMasterName = productMasterName;
		this.mrpPrice = mrpPrice;
		this.sellingPrice = sellingPrice;
		this.costPrice = costPrice;
		this.discountPercentage = discountPercentage;
		this.gstPercentage = gstPercentage;
		this.description = description;
		this.manufacturer = manufacturer;
		this.countryOfOrigin = countryOfOrigin;
		this.originType = originType;
		this.stockStatus = stockStatus;
		this.stockQuantity = stockQuantity;
		this.fittingPosition = fittingPosition;
		this.isActive = isActive;
		this.inStock = inStock;
		this.images = images;
		this.compatibleVehicles = compatibleVehicles;
	}



	


	 
    public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getItemName() {
		return itemName;
	}



	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



	public String getSlug() {
		return slug;
	}



	public void setSlug(String slug) {
		this.slug = slug;
	}



	public String getPartNumber() {
		return partNumber;
	}



	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}



	public String getAlternatePartNumber() {
		return alternatePartNumber;
	}



	public void setAlternatePartNumber(String alternatePartNumber) {
		this.alternatePartNumber = alternatePartNumber;
	}



	public String getOemNumber() {
		return oemNumber;
	}



	public void setOemNumber(String oemNumber) {
		this.oemNumber = oemNumber;
	}



	public String getHsnCode() {
		return hsnCode;
	}



	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}



	public String getSku() {
		return sku;
	}



	public void setSku(String sku) {
		this.sku = sku;
	}



	public String getBrandName() {
		return brandName;
	}



	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}



	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	public String getProductMasterName() {
		return productMasterName;
	}



	public void setProductMasterName(String productMasterName) {
		this.productMasterName = productMasterName;
	}



	public BigDecimal getMrpPrice() {
		return mrpPrice;
	}



	public void setMrpPrice(BigDecimal mrpPrice) {
		this.mrpPrice = mrpPrice;
	}



	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}



	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}



	public BigDecimal getCostPrice() {
		return costPrice;
	}



	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}



	public BigDecimal getDiscountPercentage() {
		return discountPercentage;
	}



	public void setDiscountPercentage(BigDecimal discountPercentage) {
		this.discountPercentage = discountPercentage;
	}



	public BigDecimal getGstPercentage() {
		return gstPercentage;
	}



	public void setGstPercentage(BigDecimal gstPercentage) {
		this.gstPercentage = gstPercentage;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getManufacturer() {
		return manufacturer;
	}



	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}



	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}



	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}



	public String getOriginType() {
		return originType;
	}



	public void setOriginType(String originType) {
		this.originType = originType;
	}



	public String getStockStatus() {
		return stockStatus;
	}



	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}



	public Integer getStockQuantity() {
		return stockQuantity;
	}



	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}



	public String getFittingPosition() {
		return fittingPosition;
	}



	public void setFittingPosition(String fittingPosition) {
		this.fittingPosition = fittingPosition;
	}



	public Boolean getIsActive() {
		return isActive;
	}



	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}



	public Boolean getInStock() {
		return inStock;
	}



	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}



	public List<String> getImages() {
		return images;
	}



	public void setImages(List<String> images) {
		this.images = images;
	}



	public List<VehicleCompatibilityDTO> getCompatibleVehicles() {
		return compatibleVehicles;
	}



	public void setCompatibleVehicles(List<VehicleCompatibilityDTO> compatibleVehicles) {
		this.compatibleVehicles = compatibleVehicles;
	}



	@Override
    public String toString() {
        return "ProductDetailResponseDTO [id=" + id + ", itemName=" + itemName + ", slug="
                + slug + ", partNumber=" + partNumber + ", brandName=" + brandName + "]";
    }
}