package com.DTO;

import java.math.BigDecimal;

public class CustomerReportRowDTO {

    private Long customerId;

    private String customerName;

    private String phone;

    private Long totalOrders;

    private BigDecimal totalPurchaseAmount;


    public CustomerReportRowDTO() {
		super();
	}

	public CustomerReportRowDTO(Long customerId, String customerName, String phone, Long totalOrders,
			BigDecimal totalPurchaseAmount) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.phone = phone;
		this.totalOrders = totalOrders;
		this.totalPurchaseAmount = totalPurchaseAmount;
	}

	public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(
            String customerName) {

        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(Long totalOrders) {
        this.totalOrders = totalOrders;
    }

    public BigDecimal getTotalPurchaseAmount() {
        return totalPurchaseAmount;
    }

    public void setTotalPurchaseAmount(
            BigDecimal totalPurchaseAmount) {

        this.totalPurchaseAmount =
                totalPurchaseAmount;
    }
}