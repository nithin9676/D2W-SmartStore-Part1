package com.Repostory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.ProductBrand;

@Repository
public interface ProductBrandRepository extends JpaRepository<ProductBrand, Long> {

    Optional<ProductBrand> findByBrandNameIgnoreCase(String brandName);

}