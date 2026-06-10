package com.DTO;

public class CustomerReportDTO {

    private Long totalCustomers;
    private Long totalOrders;
    private Double totalPurchaseAmount;

    public CustomerReportDTO() {
    }

    public CustomerReportDTO(
            Long totalCustomers,
            Long totalOrders,
            Double totalPurchaseAmount) {

        this.totalCustomers = totalCustomers;
        this.totalOrders = totalOrders;
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public Long getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(Long totalCustomers) {
        this.totalCustomers = totalCustomers;
    }

    public Long getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(Long totalOrders) {
        this.totalOrders = totalOrders;
    }

    public Double getTotalPurchaseAmount() {
        return totalPurchaseAmount;
    }

    public void setTotalPurchaseAmount(
            Double totalPurchaseAmount) {

        this.totalPurchaseAmount =
                totalPurchaseAmount;
    }
}