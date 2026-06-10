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
    name = "vehicle_variants",
    indexes = {
        @Index(name = "idx_variant_name", columnList = "variant_name"),
        @Index(name = "idx_engine_code", columnList = "engine_code"),
        @Index(name = "idx_variant_slug", columnList = "slug")
    }
)
public class VehicleVariant {

   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  

    @Column(name = "variant_name", nullable = false)
    private String variantName;

    @Column(name = "full_name")
    private String fullName;

    @Column( unique = true)
    private String slug;

   

    @Column(name = "start_year", nullable = false)
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

   
    @Column(name = "engine_code", nullable = false)
    private String engineCode;

    @Column(name = "fuel_type", nullable = false)
    private String fuelType;

    @Column(nullable = false)
    private String transmission;

    @Column(name = "chassis_code")
    private String chassisCode;

    @Column(nullable = false)
    private String region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "generation_id", nullable = false)
    private VehicleGeneration vehicleGeneration;

   

    @Column(name = "is_active")
    private Boolean isActive = true;

  


    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

	public VehicleVariant() {
		super();
	}

	public VehicleVariant(Long id, String variantName, String fullName, String slug, Integer startYear, Integer endYear,
			String engineCode, String fuelType, String transmission, String chassisCode, String region,
			VehicleGeneration vehicleGeneration, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.variantName = variantName;
		this.fullName = fullName;
		this.slug = slug;
		this.startYear = startYear;
		this.endYear = endYear;
		this.engineCode = engineCode;
		this.fuelType = fuelType;
		this.transmission = transmission;
		this.chassisCode = chassisCode;
		this.region = region;
		this.vehicleGeneration = vehicleGeneration;
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

	public String getVariantName() {
		return variantName;
	}

	public void setVariantName(String variantName) {
		this.variantName = variantName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getEngineCode() {
		return engineCode;
	}

	public void setEngineCode(String engineCode) {
		this.engineCode = engineCode;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getChassisCode() {
		return chassisCode;
	}

	public void setChassisCode(String chassisCode) {
		this.chassisCode = chassisCode;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public VehicleGeneration getVehicleGeneration() {
		return vehicleGeneration;
	}

	public void setVehicleGeneration(VehicleGeneration vehicleGeneration) {
		this.vehicleGeneration = vehicleGeneration;
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