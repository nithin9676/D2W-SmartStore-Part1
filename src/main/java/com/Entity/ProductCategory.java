package com.Entity;

import java.time.LocalDateTime;
import java.util.List;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity

@Table(
    name = "product_categories",
    indexes = {
        @Index(name = "idx_category_name", columnList = "category_name"),
        @Index(name = "idx_category_slug", columnList = "slug")
    }
)
public class ProductCategory {

    /* ================= PRIMARY KEY ================= */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* ================= BASIC INFO ================= */

    @Column(name = "category_name", nullable = false, unique = true)
    private String categoryName;

    @Column( unique = true)
    private String slug;

    @Column(length = 500)
    private String description;



    @Column(name = "icon_url")
    private String iconUrl;

    @Column(name = "banner_image_url")
    private String bannerImageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id")
    private ProductCategory parentCategory;

    @OneToMany(mappedBy = "parentCategory")
    private List<ProductCategory> subCategories;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

	public ProductCategory() {
		super();
	}

	public ProductCategory(Long id, String categoryName, String slug, String description, String iconUrl,
			String bannerImageUrl, ProductCategory parentCategory, List<ProductCategory> subCategories,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.slug = slug;
		this.description = description;
		this.iconUrl = iconUrl;
		this.bannerImageUrl = bannerImageUrl;
		this.parentCategory = parentCategory;
		this.subCategories = subCategories;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getBannerImageUrl() {
		return bannerImageUrl;
	}

	public void setBannerImageUrl(String bannerImageUrl) {
		this.bannerImageUrl = bannerImageUrl;
	}

	public ProductCategory getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(ProductCategory parentCategory) {
		this.parentCategory = parentCategory;
	}

	public List<ProductCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<ProductCategory> subCategories) {
		this.subCategories = subCategories;
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