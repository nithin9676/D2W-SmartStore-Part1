package com.DTO;

public class SalesReportDTO {

    private Long totalOrders;
    private Double totalRevenue;
    private Long totalCustomers;
    private Double averageOrderValue;
	public SalesReportDTO() {
		super();
	}
	public SalesReportDTO(Long totalOrders, Double totalRevenue, Long totalCustomers, Double averageOrderValue) {
		super();
		this.totalOrders = totalOrders;
		this.totalRevenue = totalRevenue;
		this.totalCustomers = totalCustomers;
		this.averageOrderValue = averageOrderValue;
	}
	public Long getTotalOrders() {
		return totalOrders;
	}
	public void setTotalOrders(Long totalOrders) {
		this.totalOrders = totalOrders;
	}
	public Double getTotalRevenue() {
		return totalRevenue;
	}
	public void setTotalRevenue(Double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
	public Long getTotalCustomers() {
		return totalCustomers;
	}
	public void setTotalCustomers(Long totalCustomers) {
		this.totalCustomers = totalCustomers;
	}
	public Double getAverageOrderValue() {
		return averageOrderValue;
	}
	public void setAverageOrderValue(Double averageOrderValue) {
		this.averageOrderValue = averageOrderValue;
	}
    
    

  }