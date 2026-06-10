package com.DTO;

import java.math.BigDecimal;

public class DeadStockDTO {

    private String productName;
    private String partNumber;
    private Integer stockQuantity;
    private BigDecimal stockValue;

    public DeadStockDTO(
            String productName,
            String partNumber,
            Integer stockQuantity,
            BigDecimal stockValue) {

        this.productName = productName;
        this.partNumber = partNumber;
        this.stockQuantity = stockQuantity;
        this.stockValue = stockValue;
    }

    public String getProductName() {
        return productName;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public BigDecimal getStockValue() {
        return stockValue;
    }
}