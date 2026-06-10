package com.DTO;

import java.math.BigDecimal;

public class ProductSearchResponseDTO {

    private Long id;

    private String itemName;

    private String slug;

    private String partNumber;

    private String brandName;

    private String categoryName;

    private String partName;

    private String mainImageUrl;

    private BigDecimal sellingPrice;

    private Boolean inStock;
    private Integer availableQty;
    private String stockStatus;
    private Integer storeQuantity;
    private Boolean availbleInStore;
    
    
    
	public ProductSearchResponseDTO() {
		super();
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



	public String getPartName() {
		return partName;
	}



	public void setPartName(String partName) {
		this.partName = partName;
	}



	public String getMainImageUrl() {
		return mainImageUrl;
	}



	public void setMainImageUrl(String mainImageUrl) {
		this.mainImageUrl = mainImageUrl;
	}



	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}



	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}



	public Boolean getInStock() {
		return inStock;
	}



	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}



	public Integer getAvailableQty() {
		return availableQty;
	}



	public void setAvailableQty(Integer availableQty) {
		this.availableQty = availableQty;
	}



	public String getStockStatus() {
		return stockStatus;
	}



	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}



	public Integer getStoreQuantity() {
		return storeQuantity;
	}



	public void setStoreQuantity(Integer storeQuantity) {
		this.storeQuantity = storeQuantity;
	}



	public Boolean getAvailbleInStore() {
		return availbleInStore;
	}



	public void setAvailbleInStore(Boolean availbleInStore) {
		this.availbleInStore = availbleInStore;
	}



	public ProductSearchResponseDTO(Long id, String itemName, String slug, String partNumber, String brandName,
			String categoryName, String partName, String mainImageUrl, BigDecimal sellingPrice, Boolean inStock) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.slug = slug;
		this.partNumber = partNumber;
		this.brandName = brandName;
		this.categoryName = categoryName;
		this.partName = partName;
		this.mainImageUrl = mainImageUrl;
		this.sellingPrice = sellingPrice;
		this.inStock = inStock;
	}



	public ProductSearchResponseDTO(Long id, String itemName, String slug, String partNumber, String brandName,
			String categoryName, String partName, String mainImageUrl, BigDecimal sellingPrice, Boolean inStock,
			Integer availableQty, String stockStatus, Integer storeQuantity, Boolean availbleInStore) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.slug = slug;
		this.partNumber = partNumber;
		this.brandName = brandName;
		this.categoryName = categoryName;
		this.partName = partName;
		this.mainImageUrl = mainImageUrl;
		this.sellingPrice = sellingPrice;
		this.inStock = inStock;
		this.availableQty = availableQty;
		this.stockStatus = stockStatus;
		this.storeQuantity = storeQuantity;
		this.availbleInStore = availbleInStore;
	}




    
}

   