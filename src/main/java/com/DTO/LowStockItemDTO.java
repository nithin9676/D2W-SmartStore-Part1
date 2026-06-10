package com.DTO;

public class LowStockItemDTO {

    private Long inventoryId;
    private String productName;
    private String storeName;
    private Integer currentStock;
    private Integer minimumStock;
    private String status;

    public LowStockItemDTO(
            Long inventoryId,
            String productName,
            String storeName,
            Integer currentStock,
            Integer minimumStock,
            String status) {

        this.inventoryId = inventoryId;
        this.productName = productName;
        this.storeName = storeName;
        this.currentStock = currentStock;
        this.minimumStock = minimumStock;
        this.status = status;
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public String getProductName() {
        return productName;
    }

    public String getStoreName() {
        return storeName;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public Integer getMinimumStock() {
        return minimumStock;
    }

    public String getStatus() {
        return status;
    }
}