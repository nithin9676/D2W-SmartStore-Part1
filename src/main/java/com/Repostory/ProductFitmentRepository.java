package com.Repostory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DTO.ProductSearchResponseDTO;
import com.DTO.TopVehicleDTO;
import com.Entity.ProductFitment;

@Repository
public interface ProductFitmentRepository extends JpaRepository<ProductFitment, Long> {

    Optional<ProductFitment> findByProductItem_IdAndVehicleVariant_Id(
            Long productItemId,
            Long variantId
    );

    List<ProductFitment> findByVehicleVariant_Id(Long variantId);

    List<ProductFitment> findByProductItem_Id(Long productId);

    @Query("""
        SELECT new com.DTO.ProductSearchResponseDTO(
            p.id,
            p.itemName,
            p.slug,
            p.partNumber,
            pb.brandName,
            pc.categoryName,
            pm.masterName,
            p.mainImageUrl,
            p.sellingPrice,
            CASE
                WHEN p.stockQuantity > 0 THEN true
                ELSE false
            END
        )
        FROM ProductFitment pf
        JOIN pf.productItem p
        JOIN p.partMaster pm
        JOIN pm.category pc
        JOIN p.partBrand pb
        WHERE pf.vehicleVariant.id = :variantId
    """)
    List<ProductSearchResponseDTO> getProductsByVariant(Long variantId);
    
    @Query("""
    		SELECT new com.DTO.TopVehicleDTO(
    		    pf.vehicleVariant.fullName,
    		    SUM(oi.quantity),
    		    SUM(oi.totalPrice)
    		)
    		FROM OrderItem oi
    		JOIN ProductFitment pf
    		    ON pf.productItem.id = oi.productItem.id
    		GROUP BY
    		pf.vehicleVariant.fullName
    		ORDER BY SUM(oi.quantity) DESC
    		""")
    		List<TopVehicleDTO>
    		getTopSellingVehicles();
}