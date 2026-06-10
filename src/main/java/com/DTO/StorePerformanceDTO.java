package com.DTO;

import java.math.BigDecimal;

public class StorePerformanceDTO {

    private String storeName;
    private Long totalOrders;
    private BigDecimal revenue;

    public StorePerformanceDTO(
            String storeName,
            Long totalOrders,
            BigDecimal revenue) {

        this.storeName = storeName;
        this.totalOrders = totalOrders;
        this.revenue = revenue;
    }

    public String getStoreName() {
        return storeName;
    }

    public Long getTotalOrders() {
        return totalOrders;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }
}