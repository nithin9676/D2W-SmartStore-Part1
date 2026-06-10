package com.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CustomerOrderHistoryDTO {
	private Long orderId;
	private String customerName;
	private BigDecimal totalAmount;
	private String paymentMethod;
	private LocalDateTime orderDate;
	public CustomerOrderHistoryDTO(Long orderId, String customerName, BigDecimal totalAmount, String paymentMethod,
			LocalDateTime orderDate) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
		this.orderDate = orderDate;
	}
	public CustomerOrderHistoryDTO() {
		super();
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
	
	

}
