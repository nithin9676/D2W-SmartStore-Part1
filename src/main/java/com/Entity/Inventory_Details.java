//package com.Entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//
//@Entity
//public class Inventory_Details {
//	
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	Long id;
//	@ManyToOne
//	
//	Store_Details store;
//	@ManyToOne
//	
//	PartItem_Details partItem;
//	Long quantity;
//	public Inventory_Details() {
//		super();
//	}
//	public Inventory_Details(Long id, Store_Details store, PartItem_Details partItem, Long quantity) {
//		super();
//		this.id = id;
//		this.store = store;
//		this.partItem = partItem;
//		this.quantity = quantity;
//	}
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public Store_Details getStore() {
//		return store;
//	}
//	public void setStore(Store_Details store) {
//		this.store = store;
//	}
//	public PartItem_Details getPartItem() {
//		return partItem;
//	}
//	public void setPartItem(PartItem_Details partItem) {
//		this.partItem = partItem;
//	}
//	public Long getQuantity() {
//		return quantity;
//	}
//	public void setQuantity(Long quantity) {
//		this.quantity = quantity;
//	}
//	@Override
//	public String toString() {
//		return "Inventory_Details [id=" + id + ", store=" + store + ", partItem=" + partItem + ", quantity=" + quantity
//				+ "]";
//	}
//	
//	
//	
//
//}
