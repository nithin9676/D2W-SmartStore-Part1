package com.DTO;

import java.math.BigDecimal;

public class TopVehicleDTO {

    private String vehicleName;
    private Long quantitySold;
    private BigDecimal revenue;

    public TopVehicleDTO(
            String vehicleName,
            Long quantitySold,
            BigDecimal revenue) {

        this.vehicleName = vehicleName;
        this.quantitySold = quantitySold;
        this.revenue = revenue;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public Long getQuantitySold() {
        return quantitySold;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }
}