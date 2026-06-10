package com.DTO;

public class LowStockReportDTO {

    private Long totalLowStockItems;
    private Long criticalItems;

    public LowStockReportDTO() {
    }

    public Long getTotalLowStockItems() {
        return totalLowStockItems;
    }

    public void setTotalLowStockItems(Long totalLowStockItems) {
        this.totalLowStockItems = totalLowStockItems;
    }

    public Long getCriticalItems() {
        return criticalItems;
    }

    public void setCriticalItems(Long criticalItems) {
        this.criticalItems = criticalItems;
    }
}