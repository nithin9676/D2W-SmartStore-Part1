
	package com.DTO;

	import java.math.BigDecimal;
	import java.time.LocalDateTime;
	import java.util.List;

	public class InvoiceResponseDTO {

	    private Long orderId;

	    private String customerName;

	    private String phone;

	    private String paymentMethod;

	    private BigDecimal totalAmount;

	    private LocalDateTime orderDate;

	    private List<InvoiceItemDTO> items;

	    public InvoiceResponseDTO() {
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

	    public LocalDateTime getOrderDate() {
	        return orderDate;
	    }

	    public void setOrderDate(LocalDateTime orderDate) {
	        this.orderDate = orderDate;
	    }

	    public List<InvoiceItemDTO> getItems() {
	        return items;
	    }

	    public void setItems(List<InvoiceItemDTO> items) {
	        this.items = items;
	    }
	
}
