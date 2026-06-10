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
    name = "product_brands",
    indexes = {
        @Index(name = "idx_brand_name", columnList = "brand_name"),
        @Index(name = "idx_brand_slug", columnList = "slug")
    }
)
public class ProductBrand {

   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  

    @Column(name = "brand_name", nullable = false, unique = true)
    private String brandName;

    @Column( unique = true)
    private String slug;

    @Column(length = 1000)
    private String description;

    @Column(name = "logo_url")
    private String logoUrl;

  
    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "is_featured")
    private Boolean featured = false;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

	public ProductBrand() {
		super();
	}

	public ProductBrand(Long id, String brandName, String slug, String description, String logoUrl, Boolean isActive,
			Boolean featured, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.brandName = brandName;
		this.slug = slug;
		this.description = description;
		this.logoUrl = logoUrl;
		this.isActive = isActive;
		this.featured = featured;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Boolean getFeatured() {
		return featured;
	}

	public void setFeatured(Boolean featured) {
		this.featured = featured;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
    
    


}