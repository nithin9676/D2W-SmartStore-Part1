package com.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;



import com.enumclasses.ApprovalStatus;
import com.enumclasses.FittingPosition;
import com.enumclasses.OriginType;
import com.enumclasses.StockStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "product_items",
    indexes = {
        @Index(name = "idx_part_number", columnList = "part_number"),
        @Index(name = "idx_hsn_code", columnList = "hsn_code"),
        @Index(name = "idx_sku", columnList = "sku"),
        @Index(name = "idx_item_name", columnList = "item_name")
    }
)
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "item_name", nullable = false)
    private String itemName;
    @Column(unique = true, nullable = false)
    private String slug;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "part_number", nullable = false, unique = true)
    private String partNumber;
    @Column(name = "alternate_part_number")
    private String alternatePartNumber;

    @Column(name = "oem_number")
    private String oemNumber;

    @Column(name = "hsn_code")
    private String hsnCode;

    @Column(nullable = false, unique = true)
    private String sku;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partmaster_id", nullable = false)
    private ProductMaster partMaster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partbrand_id", nullable = false)
    private ProductBrand partBrand;
    @Column(name = "mrp_price", precision = 10, scale = 2)
    private BigDecimal mrpPrice;
    @Column(name = "selling_price", precision = 10, scale = 2)
    private BigDecimal sellingPrice;
    @Column(name = "cost_price", precision = 10, scale = 2)
    private BigDecimal costPrice;

    @Column(name = "discount_percentage", precision = 5, scale = 2)
    private BigDecimal discountPercentage;

    @Column(name = "gst_percentage", precision = 5, scale = 2)
    private BigDecimal gstPercentage;

  

    @Column(name = "stock_quantity")
    private Integer stockQuantity = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "stock_status")
    private StockStatus stockStatus = StockStatus.IN_STOCK;


    @Column(name = "is_active")
    private Boolean isActive = true;


    @Enumerated(EnumType.STRING)
    @Column(name = "approval_status")
    private ApprovalStatus approvalStatus = ApprovalStatus.APPROVED;



    @Enumerated(EnumType.STRING)
    @Column(name = "origin_type")
    private OriginType originType;


    @Column(name = "main_image_url")
    private String mainImageUrl;

    @Column(name = "secondary_image_url")
    private String secondaryImageUrl;

    @Column(name = "third_image_url")
    private String thirdImageUrl;


    private String manufacturer;

    @Column(name = "country_of_origin")
    private String countryOfOrigin;


    @Enumerated(EnumType.STRING)
    @Column(name = "fitting_position")
    private FittingPosition fittingPosition;


    @Column(name = "meta_title")
    private String metaTitle;

    @Column(name = "meta_description", length = 1000)
    private String metaDescription;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

	public ProductItem() {
		super();
	}

	public ProductItem(Long id, String itemName, String slug, String description, String partNumber,
			String alternatePartNumber, String oemNumber, String hsnCode, String sku, ProductMaster partMaster,
			ProductBrand partBrand, BigDecimal mrpPrice, BigDecimal sellingPrice, BigDecimal costPrice,
			BigDecimal discountPercentage, BigDecimal gstPercentage, Integer stockQuantity, StockStatus stockStatus,
			Boolean isActive, ApprovalStatus approvalStatus, OriginType originType, String mainImageUrl,
			String secondaryImageUrl, String thirdImageUrl, String manufacturer, String countryOfOrigin,
			FittingPosition fittingPosition, String metaTitle, String metaDescription, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.slug = slug;
		this.description = description;
		this.partNumber = partNumber;
		this.alternatePartNumber = alternatePartNumber;
		this.oemNumber = oemNumber;
		this.hsnCode = hsnCode;
		this.sku = sku;
		this.partMaster = partMaster;
		this.partBrand = partBrand;
		this.mrpPrice = mrpPrice;
		this.sellingPrice = sellingPrice;
		this.costPrice = costPrice;
		this.discountPercentage = discountPercentage;
		this.gstPercentage = gstPercentage;
		this.stockQuantity = stockQuantity;
		this.stockStatus = stockStatus;
		this.isActive = isActive;
		this.approvalStatus = approvalStatus;
		this.originType = originType;
		this.mainImageUrl = mainImageUrl;
		this.secondaryImageUrl = secondaryImageUrl;
		this.thirdImageUrl = thirdImageUrl;
		this.manufacturer = manufacturer;
		this.countryOfOrigin = countryOfOrigin;
		this.fittingPosition = fittingPosition;
		this.metaTitle = metaTitle;
		this.metaDescription = metaDescription;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public ProductMaster getPartMaster() {
		return partMaster;
	}

	public void setPartMaster(ProductMaster partMaster) {
		this.partMaster = partMaster;
	}

	public ProductBrand getPartBrand() {
		return partBrand;
	}

	public void setPartBrand(ProductBrand partBrand) {
		this.partBrand = partBrand;
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

	public Integer getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public StockStatus getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(StockStatus stockStatus) {
		this.stockStatus = stockStatus;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public ApprovalStatus getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(ApprovalStatus approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public OriginType getOriginType() {
		return originType;
	}

	public void setOriginType(OriginType originType) {
		this.originType = originType;
	}

	public String getMainImageUrl() {
		return mainImageUrl;
	}

	public void setMainImageUrl(String mainImageUrl) {
		this.mainImageUrl = mainImageUrl;
	}

	public String getSecondaryImageUrl() {
		return secondaryImageUrl;
	}

	public void setSecondaryImageUrl(String secondaryImageUrl) {
		this.secondaryImageUrl = secondaryImageUrl;
	}

	public String getThirdImageUrl() {
		return thirdImageUrl;
	}

	public void setThirdImageUrl(String thirdImageUrl) {
		this.thirdImageUrl = thirdImageUrl;
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

	public FittingPosition getFittingPosition() {
		return fittingPosition;
	}

	public void setFittingPosition(FittingPosition fittingPosition) {
		this.fittingPosition = fittingPosition;
	}

	public String getMetaTitle() {
		return metaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    

}