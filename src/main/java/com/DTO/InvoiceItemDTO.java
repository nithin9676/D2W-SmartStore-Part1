package com.DTO;

import java.math.BigDecimal;

public class InvoiceItemDTO {

    private String itemName;

    private Integer quantity;

    private BigDecimal sellingPrice;

    private BigDecimal totalPrice;
    private BigDecimal gstPercentage;
    private BigDecimal discountPercentage;
    private String hsncode;
    

    public InvoiceItemDTO() {
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

	public BigDecimal getGstPercentage() {
		return gstPercentage;
	}

	public void setGstPercentage(BigDecimal gstPercentage) {
		this.gstPercentage = gstPercentage;
	}

	public BigDecimal getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(BigDecimal discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public String getHsncode() {
		return hsncode;
	}

	public void setHsncode(String hsncode) {
		this.hsncode = hsncode;
	}

	public InvoiceItemDTO(String itemName, Integer quantity, BigDecimal sellingPrice, BigDecimal totalPrice,
			BigDecimal gstPercentage, BigDecimal discountPercentage, String hsncode) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
		this.sellingPrice = sellingPrice;
		this.totalPrice = totalPrice;
		this.gstPercentage = gstPercentage;
		this.discountPercentage = discountPercentage;
		this.hsncode = hsncode;
	}
    
}