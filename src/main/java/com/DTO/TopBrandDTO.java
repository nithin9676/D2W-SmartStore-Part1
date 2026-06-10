package com.DTO;

import java.math.BigDecimal;

public class TopBrandDTO {

    private String brandName;
    private Long quantitySold;
    private BigDecimal revenue;

    public TopBrandDTO(
            String brandName,
            Long quantitySold,
            BigDecimal revenue) {

        this.brandName = brandName;
        this.quantitySold = quantitySold;
        this.revenue = revenue;
    }

    public String getBrandName() {
        return brandName;
    }

    public Long getQuantitySold() {
        return quantitySold;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }
}