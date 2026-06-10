package com.DTO;

public class DashboardDto {

    private Double todaySales;
    private Long todayOrders;

    private Double totalRevenue;

    private Long totalProducts;
    private Long totalCustomers;
    private Long totalStores;

    private Long inventoryItems;
    private Long stockQuantity;

    private Long lowStockItems;
    private Long outOfStockItems;

    private Long pendingOrders;
    private Long deliveredOrders;
    private Long cancelledOrders;
    private Long totalOrders;

    private Double pendingPayments;

    public DashboardDto() {
    }

	

	public Double getTodaySales() {
		return todaySales;
	}

	public void setTodaySales(Double todaySales) {
		this.todaySales = todaySales;
	}

	public Long getTodayOrders() {
		return todayOrders;
	}

	public void setTodayOrders(Long todayOrders) {
		this.todayOrders = todayOrders;
	}

	public Double getTotalRevenue() {
		return totalRevenue;
	}
	
	
	public Long getTotalOrders() {
		return totalOrders;
	}



	public void setTotalOrders(Long totalOrders) {
		this.totalOrders = totalOrders;
	}



	public void setTotalRevenue(Double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public Long getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(Long totalProducts) {
		this.totalProducts = totalProducts;
	}

	public Long getTotalCustomers() {
		return totalCustomers;
	}

	public void setTotalCustomers(Long totalCustomers) {
		this.totalCustomers = totalCustomers;
	}

	public Long getTotalStores() {
		return totalStores;
	}

	public void setTotalStores(Long totalStores) {
		this.totalStores = totalStores;
	}

	public Long getInventoryItems() {
		return inventoryItems;
	}

	public void setInventoryItems(Long inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

	public Long getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Long stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Long getLowStockItems() {
		return lowStockItems;
	}

	public void setLowStockItems(Long lowStockItems) {
		this.lowStockItems = lowStockItems;
	}

	public Long getOutOfStockItems() {
		return outOfStockItems;
	}

	public void setOutOfStockItems(Long outOfStockItems) {
		this.outOfStockItems = outOfStockItems;
	}

	public Long getPendingOrders() {
		return pendingOrders;
	}

	public void setPendingOrders(Long pendingOrders) {
		this.pendingOrders = pendingOrders;
	}

	public Long getDeliveredOrders() {
		return deliveredOrders;
	}

	public void setDeliveredOrders(Long deliveredOrders) {
		this.deliveredOrders = deliveredOrders;
	}

	public Long getCancelledOrders() {
		return cancelledOrders;
	}

	public void setCancelledOrders(Long cancelledOrders) {
		this.cancelledOrders = cancelledOrders;
	}

	public Double getPendingPayments() {
		return pendingPayments;
	}

	public void setPendingPayments(Double pendingPayments) {
		this.pendingPayments = pendingPayments;
	}



	public DashboardDto(Double todaySales, Long todayOrders, Double totalRevenue, Long totalProducts,
			Long totalCustomers, Long totalStores, Long inventoryItems, Long stockQuantity, Long lowStockItems,
			Long outOfStockItems, Long pendingOrders, Long deliveredOrders, Long cancelledOrders, Long totalOrders,
			Double pendingPayments) {
		super();
		this.todaySales = todaySales;
		this.todayOrders = todayOrders;
		this.totalRevenue = totalRevenue;
		this.totalProducts = totalProducts;
		this.totalCustomers = totalCustomers;
		this.totalStores = totalStores;
		this.inventoryItems = inventoryItems;
		this.stockQuantity = stockQuantity;
		this.lowStockItems = lowStockItems;
		this.outOfStockItems = outOfStockItems;
		this.pendingOrders = pendingOrders;
		this.deliveredOrders = deliveredOrders;
		this.cancelledOrders = cancelledOrders;
		this.totalOrders = totalOrders;
		this.pendingPayments = pendingPayments;
	}
	

    
}