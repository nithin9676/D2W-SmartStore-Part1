package com.DTO;

import java.math.BigDecimal;

public class OrderItemDTO {

    private Long productId;

    private Integer quantity;

    private BigDecimal sellingPrice;

    private BigDecimal totalPrice;
    private BigDecimal gstPercentage;
    private BigDecimal discountPercentage;
    private String hsnCode;
    
    


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

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public OrderItemDTO() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

	public OrderItemDTO(Long productId, Integer quantity, BigDecimal sellingPrice, BigDecimal totalPrice,
			BigDecimal gstPercentage, BigDecimal discountPercentage, String hsnCode) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.sellingPrice = sellingPrice;
		this.totalPrice = totalPrice;
		this.gstPercentage = gstPercentage;
		this.discountPercentage = discountPercentage;
		this.hsnCode = hsnCode;
	}
    
}