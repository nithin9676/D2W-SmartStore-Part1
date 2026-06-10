package com.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class OrderMaster {

    @Id
    @GeneratedValue(strategy =
        GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    private String phone;

    private String address;

    private String paymentMethod;

    private BigDecimal totalAmount;

    private LocalDateTime orderDate =
        LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    public OrderMaster() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(
        String customerName) {

        this.customerName =
            customerName;
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

    public void setAddress(
        String address) {

        this.address = address;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(
        String paymentMethod) {

        this.paymentMethod =
            paymentMethod;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(
        BigDecimal totalAmount) {

        this.totalAmount =
            totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(
        LocalDateTime orderDate) {

        this.orderDate =
            orderDate;
    }

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public OrderMaster(Long id, String customerName, String phone, String address, String paymentMethod,
			BigDecimal totalAmount, LocalDateTime orderDate, Store store, Customer customer) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.phone = phone;
		this.address = address;
		this.paymentMethod = paymentMethod;
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
		this.store = store;
		this.customer = customer;
	}

	
    
}