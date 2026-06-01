package com.Repostory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Entity.ProductItem;

@Repository
public interface ProductItemRepository
        extends JpaRepository<ProductItem, Long> {

    Optional<ProductItem>findByPartNumberIgnoreCase(String partNumber);

    List<ProductItem>findByPartMaster_Id(Long partMasterId);

    @Query("""
    		SELECT p FROM ProductItem p
    		WHERE
    		LOWER(p.itemName) LIKE LOWER(CONCAT('%', :text, '%'))
    		OR LOWER(p.partNumber) LIKE LOWER(CONCAT('%', :text, '%'))
    		OR LOWER(p.hsnCode) LIKE LOWER(CONCAT('%', :text, '%'))
    		OR LOWER(p.oemNumber) LIKE LOWER(CONCAT('%', :text, '%'))
    		OR LOWER(p.sku) LIKE LOWER(CONCAT('%', :text, '%'))
    		OR LOWER(p.partBrand.brandName) LIKE LOWER(CONCAT('%', :text, '%'))
    		OR LOWER(p.partMaster.masterName) LIKE LOWER(CONCAT('%', :text, '%'))
    		OR LOWER(p.partMaster.category.categoryName) LIKE LOWER(CONCAT('%', :text, '%'))
    		""")
    		List<ProductItem> globalSearchProducts(@Param("text") String text);

}