package com.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity

@Table(
    name = "product_fitments",
    indexes = {
        @Index(name = "idx_product_item", columnList = "product_item_id"),
        @Index(name = "idx_variant", columnList = "variant_id")
    }
)
public class ProductFitment {

   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_item_id", nullable = false)
    private ProductItem productItem;

  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variant_id", nullable = false)
    private VehicleVariant vehicleVariant;

   

    @Column(length = 1000)
    private String notes;



	public ProductFitment() {
		super();
	}



	public ProductFitment(Long id, ProductItem productItem, VehicleVariant vehicleVariant, String notes) {
		super();
		this.id = id;
		this.productItem = productItem;
		this.vehicleVariant = vehicleVariant;
		this.notes = notes;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public ProductItem getProductItem() {
		return productItem;
	}



	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}



	public VehicleVariant getVehicleVariant() {
		return vehicleVariant;
	}



	public void setVehicleVariant(VehicleVariant vehicleVariant) {
		this.vehicleVariant = vehicleVariant;
	}



	public String getNotes() {
		return notes;
	}



	public void setNotes(String notes) {
		this.notes = notes;
	}
    
    

 


}