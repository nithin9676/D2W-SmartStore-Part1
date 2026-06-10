package com.DTO;

public class InventorySummaryDTO {

    private Long totalProducts;
    private Long totalStockQuantity;
    private Long lowStockItems;
    private Long outOfStockItems;

    public InventorySummaryDTO() {
    }

    public InventorySummaryDTO(
            Long totalProducts,
            Long totalStockQuantity,
            Long lowStockItems,
            Long outOfStockItems) {

        this.totalProducts = totalProducts;
        this.totalStockQuantity = totalStockQuantity;
        this.lowStockItems = lowStockItems;
        this.outOfStockItems = outOfStockItems;
    }

    public Long getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(Long totalProducts) {
        this.totalProducts = totalProducts;
    }

    public Long getTotalStockQuantity() {
        return totalStockQuantity;
    }

    public void setTotalStockQuantity(Long totalStockQuantity) {
        this.totalStockQuantity = totalStockQuantity;
    }

    public Long getLowStockItems() {
        return lowStockItems;
    }

    public void setLowStockItems(Long lowStockItems) {
        this.lowStockItems = lowStockItems;
    }

    public Long getOutOfStockItems() {
        return outOfStockItems;
    }

    public void setOutOfStockItems(Long outOfStockItems) {
        this.outOfStockItems = outOfStockItems;
    }
}