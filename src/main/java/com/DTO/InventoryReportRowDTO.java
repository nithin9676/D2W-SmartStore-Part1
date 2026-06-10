package com.DTO;

public class InventoryReportRowDTO {

    private Long inventoryId;
    private String productName;
    private String storeName;
    private Integer quantity;
    private Integer minimumStock;
    private String stockStatus;

    public InventoryReportRowDTO() {
    }

    public InventoryReportRowDTO(
            Long inventoryId,
            String productName,
            String storeName,
            Integer quantity,
            Integer minimumStock,
            String stockStatus) {

        this.inventoryId = inventoryId;
        this.productName = productName;
        this.storeName = storeName;
        this.quantity = quantity;
        this.minimumStock = minimumStock;
        this.stockStatus = stockStatus;
    }

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getMinimumStock() {
		return minimumStock;
	}

	public void setMinimumStock(Integer minimumStock) {
		this.minimumStock = minimumStock;
	}

	public String getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}

   
}