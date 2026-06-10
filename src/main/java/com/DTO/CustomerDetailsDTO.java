package com.DTO;

import java.math.BigDecimal;

public class CustomerDetailsDTO {
	
	private Long customerId;
	private String customerName;
	private String phone;
	private String address;
	private Long totalOrders;
	private BigDecimal totalPurchaseAmount;
	public CustomerDetailsDTO(Long customerId, String customerName, String phone, String address,
			Long totalOrders, BigDecimal totalPurchaseAmount) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.phone = phone;
		this.address = address;
		this.totalOrders = totalOrders;
		this.totalPurchaseAmount = totalPurchaseAmount;
	}
	public CustomerDetailsDTO() {
		super();
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
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public void setTotalPurchaseAmount(BigDecimal totalPurchaseAmount) {
		this.totalPurchaseAmount = totalPurchaseAmount;
	}
	
}