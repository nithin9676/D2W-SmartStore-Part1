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
    name = "vehicle_models",
    indexes = {
        @Index(name = "idx_model_name", columnList = "model_name"),
        @Index(name = "idx_model_slug", columnList = "slug")
    }
)
public class VehicleModel {

   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  

    @Column(name = "model_name", nullable = false)
    private String modelName;

   
    private String slug;

   

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "make_id", nullable = false)
    private VehicleMake vehicleMake;

   

    @Column(name = "is_active")
    private Boolean isActive = true;

   
   
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

	public VehicleModel() {
		super();
	}

	public VehicleModel(Long id, String modelName, String slug, VehicleMake vehicleMake, Boolean isActive,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.modelName = modelName;
		this.slug = slug;
		this.vehicleMake = vehicleMake;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public VehicleMake getVehicleMake() {
		return vehicleMake;
	}

	public void setVehicleMake(VehicleMake vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    

}