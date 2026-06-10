package com.Entity;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy =
        GenerationType.IDENTITY)
    private Long id;

    

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderMaster orderMaster;

   
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductItem productItem;

 

    private Integer quantity;

    private BigDecimal sellingPrice;

    private BigDecimal totalPrice;
    private BigDecimal gstPercentage;
    private BigDecimal discountPercentage;
    private String hsncode;
    

    public OrderItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderMaster getOrderMaster() {
        return orderMaster;
    }

    public void setOrderMaster(
        OrderMaster orderMaster) {

        this.orderMaster =
            orderMaster;
    }

    public ProductItem getProductItem() {
        return productItem;
    }

    public void setProductItem(
        ProductItem productItem) {

        this.productItem =
            productItem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(
        Integer quantity) {

        this.quantity =
            quantity;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {

        this.sellingPrice =
            sellingPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice( BigDecimal totalPrice) {

        this.totalPrice =
            totalPrice;
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

	public OrderItem(Long id, OrderMaster orderMaster, ProductItem productItem, Integer quantity,
			BigDecimal sellingPrice, BigDecimal totalPrice, BigDecimal gstPercentage, BigDecimal discountPercentage,
			String hsncode) {
		super();
		this.id = id;
		this.orderMaster = orderMaster;
		this.productItem = productItem;
		this.quantity = quantity;
		this.sellingPrice = sellingPrice;
		this.totalPrice = totalPrice;
		this.gstPercentage = gstPercentage;
		this.discountPercentage = discountPercentage;
		this.hsncode = hsncode;
	}
    
}