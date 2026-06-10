package com.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderListResponseDTO {

    private Long orderId;

    private String customerName;

    private String phone;

    private String paymentMethod;

    private BigDecimal totalAmount;

    private Integer totalItems;

    private LocalDateTime orderDate;

    public OrderListResponseDTO() {
    }

    public OrderListResponseDTO(
            Long orderId,
            String customerName,
            String phone,
            String paymentMethod,
            BigDecimal totalAmount,
            Integer totalItems,
            LocalDateTime orderDate) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.phone = phone;
        this.paymentMethod = paymentMethod;
        this.totalAmount = totalAmount;
        this.totalItems = totalItems;
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

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

    
}