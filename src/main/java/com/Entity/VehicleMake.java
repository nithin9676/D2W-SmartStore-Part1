package com.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;



@Entity

@Table(
    name = "vehicle_makes",
    indexes = {
        @Index(name = "idx_make_name", columnList = "make_name"),
        @Index(name = "idx_make_slug", columnList = "slug")
    }
)
public class VehicleMake {

    /* ================= PRIMARY KEY ================= */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* ================= BASIC INFO ================= */

    @Column(name = "make_name", unique = true)
    private String makeName;


    private String slug;

    /* ================= MEDIA ================= */

    @Column(name = "logo_url")
    private String logoUrl;

    /* ================= STATUS ================= */

    @Column(name = "is_active")
    private Boolean isActive = true;

    /* ================= AUDIT ================= */

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

	public VehicleMake() {
		super();
	}

	public VehicleMake(Long id, String makeName, String slug, String logoUrl, Boolean isActive, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.makeName = makeName;
		this.slug = slug;
		this.logoUrl = logoUrl;
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

	public String getMakeName() {
		return makeName;
	}

	public void setMakeName(String makeName) {
		this.makeName = makeName;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
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