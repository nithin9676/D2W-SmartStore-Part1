package com.Entity;

	import jakarta.persistence.*;

	@Entity
	@Table(name = "customers")
	
	public class Customer {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String customerName;

	    @Column(unique = true)
	    private String mobileNumber;

	    private String address;

	    public Customer() {
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

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }

	    public String getMobileNumber() {
	        return mobileNumber;
	    }

	    public void setMobileNumber(String mobileNumber) {
	        this.mobileNumber = mobileNumber;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }
	

}
