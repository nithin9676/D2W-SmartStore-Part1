package com.DTO;

import java.math.BigDecimal;

public class TopCategoryDTO {

    private String categoryName;
    private Long quantitySold;
    private BigDecimal revenue;

    public TopCategoryDTO(
            String categoryName,
            Long quantitySold,
            BigDecimal revenue) {

        this.categoryName = categoryName;
        this.quantitySold = quantitySold;
        this.revenue = revenue;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Long getQuantitySold() {
        return quantitySold;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }
}