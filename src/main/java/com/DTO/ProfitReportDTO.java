package com.DTO;

import java.math.BigDecimal;

public class ProfitReportDTO {

    private BigDecimal totalRevenue;
    private BigDecimal totalCost;
    private BigDecimal totalProfit;

    public ProfitReportDTO(
            BigDecimal totalRevenue,
            BigDecimal totalCost,
            BigDecimal totalProfit) {

        this.totalRevenue = totalRevenue;
        this.totalCost = totalCost;
        this.totalProfit = totalProfit;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public BigDecimal getTotalProfit() {
        return totalProfit;
    }
}