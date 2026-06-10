package com.DTO;

public class StoreResponse_Dto {
	
	String storeName;
	String city;
	String pincode;
	Long storeID;
	long quantity;
	String stockstatus;
	Long pincodeDifference;
	private Integer minimumStock;
	public StoreResponse_Dto() {
		super();
	}
	public StoreResponse_Dto(String storeName, String city, String pincode, long quantity, String stockstatus,Long pincodeDifference,Long storeId) {
		super();
		this.storeID=storeId;
		this.storeName = storeName;
		this.city = city;
		this.pincode = pincode;
		this.quantity = quantity;
		this.stockstatus = stockstatus;
		this.pincodeDifference=pincodeDifference;
	}
	
	
	public Long getStoreID() {
		return storeID;
	}
	public void setStoreID(Long storeID) {
		this.storeID = storeID;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getStockstatus() {
		return stockstatus;
	}
	public void setStockstatus(String stockstatus) {
		this.stockstatus = stockstatus;
	}
	public Long getPincodeDifference() {
		return pincodeDifference;
	}
	public void setPincodeDifference(Long pincodeDifference) {
		this.pincodeDifference = pincodeDifference;
	}
	
	
	
 
}
