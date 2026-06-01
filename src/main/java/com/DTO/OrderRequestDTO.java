package com.DTO;

import java.math.BigDecimal;
import java.util.List;

public class OrderRequestDTO {

    private String customerName;

    private String phone;

    private String address;

    private String paymentMethod;

    private BigDecimal totalAmount;

    private List<OrderItemDTO> items;
    private Long storeId;
    public OrderRequestDTO() {
    }

    
    public Long getStoreId() {
		return storeId;
	}


	public void setStoreId(Long storeId) {
		this.storeId = storeId;
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

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }


	public OrderRequestDTO(String customerName, String phone, String address, String paymentMethod,
			BigDecimal totalAmount, List<OrderItemDTO> items, Long storeId) {
		super();
		this.customerName = customerName;
		this.phone = phone;
		this.address = address;
		this.paymentMethod = paymentMethod;
		this.totalAmount = totalAmount;
		this.items = items;
		this.storeId = storeId;
	}
    
}