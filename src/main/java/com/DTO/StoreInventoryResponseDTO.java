package com.DTO;

import java.math.BigDecimal;

public class StoreInventoryResponseDTO {

    private Long inventoryId;

    private Long productId;

    private String itemName;

    private String brandName;

    private String partNumber;

    private Integer quantity;

    private BigDecimal sellingPrice;
    private String image;

    private Boolean inStock;
    
    private String description;

    private String sku;

    private String categoryName;

    private String productMasterName;
    private Integer minimumStock;
    private BigDecimal gstPercentage;
    private BigDecimal discountPercentage;
    private String hsncode;
    

    public StoreInventoryResponseDTO() {
    }

    
    
    public String getHsncode() {
		return hsncode;
	}



	public void setHsncode(String hsncode) {
		this.hsncode = hsncode;
	}



	public Integer getMinimumStock() {
		return minimumStock;
	}


	public void setMinimumStock(Integer minimumStock) {
		this.minimumStock = minimumStock;
	}


	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Boolean getInStock() {
		return inStock;
	}

	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}

	

	

	public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
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


	public BigDecimal getGstPercentage() {
		return gstPercentage;
	}


	public void setGstPercentage(BigDecimal gstPercentage) {
		this.gstPercentage = gstPercentage;
	}


	public BigDecimal getDiscountPercentage() {
		return discountPercentage;
	}


	public void setDiscountPercentage(BigDecimal discountPercentage) {
		this.discountPercentage = discountPercentage;
	}



	public StoreInventoryResponseDTO(Long inventoryId, Long productId, String itemName, String brandName,
			String partNumber, Integer quantity, BigDecimal sellingPrice, String image, Boolean inStock,
			String description, String sku, String categoryName, String productMasterName, Integer minimumStock,
			BigDecimal gstPercentage, BigDecimal discountPercentage, String hsncode) {
		super();
		this.inventoryId = inventoryId;
		this.productId = productId;
		this.itemName = itemName;
		this.brandName = brandName;
		this.partNumber = partNumber;
		this.quantity = quantity;
		this.sellingPrice = sellingPrice;
		this.image = image;
		this.inStock = inStock;
		this.description = description;
		this.sku = sku;
		this.categoryName = categoryName;
		this.productMasterName = productMasterName;
		this.minimumStock = minimumStock;
		this.gstPercentage = gstPercentage;
		this.discountPercentage = discountPercentage;
		this.hsncode = hsncode;
	}


	


	
    
    
}