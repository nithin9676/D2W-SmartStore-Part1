package com.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SalesOrderRowDTO {

    private Long orderId;
    private String customerName;
    private String phone;
    private BigDecimal totalAmount;
    private String paymentMethod;
    private LocalDateTime orderDate;

    public SalesOrderRowDTO(Long orderId, String customerName, String phone, BigDecimal totalAmount,
			String paymentMethod, LocalDateTime orderDate) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.phone = phone;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
		this.orderDate = orderDate;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public SalesOrderRowDTO() {
		super();
	}

    
}