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
    name = "vehicle_generations",
    indexes = {
        @Index(name = "idx_generation_name", columnList = "generation_name"),
        @Index(name = "idx_generation_slug", columnList = "slug")
    }
)
public class VehicleGeneration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    @Column(name = "generation_name", nullable = false)
    private String generationName;

    @Column( unique = true)
    private String slug;

    @Column(name = "start_year", nullable = false)
    private Integer startYear;

    @Column(name = "end_year",nullable=false)
    private Integer endYear;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model_id", nullable = false)
    private VehicleModel vehicleModel;

    @Column(name = "is_active")
    private Boolean isActive = true;
 
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

	public VehicleGeneration() {
		super();
	}

	public VehicleGeneration(Long id, String generationName, String slug, Integer startYear, Integer endYear,
			VehicleModel vehicleModel, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.generationName = generationName;
		this.slug = slug;
		this.startYear = startYear;
		this.endYear = endYear;
		this.vehicleModel = vehicleModel;
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

	public String getGenerationName() {
		return generationName;
	}

	public void setGenerationName(String generationName) {
		this.generationName = generationName;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Integer getStartYear() {
		return startYear;
	}

	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}

	public Integer getEndYear() {
		return endYear;
	}

	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}

	public VehicleModel getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(VehicleModel vehicleModel) {
		this.vehicleModel = vehicleModel;
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