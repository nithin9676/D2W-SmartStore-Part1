package com.DTO;

public class StoreAnalyticsDto {
	Long storeId;
	String storeName;
	String storeType;
	Long totalOrders;
	Long totalStock;
	Double revenue;
	Long lowStockItems;
	public StoreAnalyticsDto() {
		super();
	}
	public StoreAnalyticsDto(Long storeId, String storeName, String storeType, Long totalOrders, Long totalStock,
			Double revenue, Long lowStockItems) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.storeType = storeType;
		this.totalOrders = totalOrders;
		this.totalStock = totalStock;
		this.revenue = revenue;
		this.lowStockItems = lowStockItems;
	}
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreType() {
		return storeType;
	}
	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
	public Long getTotalOrders() {
		return totalOrders;
	}
	public void setTotalOrders(Long totalOrders) {
		this.totalOrders = totalOrders;
	}
	public Long getTotalStock() {
		return totalStock;
	}
	public void setTotalStock(Long totalStock) {
		this.totalStock = totalStock;
	}
	public Double getRevenue() {
		return revenue;
	}
	public void setRevenue(Double revenue) {
		this.revenue = revenue;
	}
	public Long getLowStockItems() {
		return lowStockItems;
	}
	public void setLowStockItems(Long lowStockItems) {
		this.lowStockItems = lowStockItems;
	}
	

}
