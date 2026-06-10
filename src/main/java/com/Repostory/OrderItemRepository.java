package com.Repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.DTO.ProfitReportDTO;
import com.DTO.TopBrandDTO;
import com.DTO.TopCategoryDTO;
import com.DTO.TopSellingProductDTO;
import com.Entity.OrderItem;
import com.Entity.OrderMaster;

public interface OrderItemRepository
    extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrderMaster(
        OrderMaster orderMaster
    );
    Integer countByOrderMasterId(Long orderId);
    @Query("""
    		SELECT new com.DTO.TopSellingProductDTO(
    		    oi.productItem.itemName,
    		    SUM(oi.quantity),
    		    SUM(oi.totalPrice)
    		)
    		FROM OrderItem oi
    		GROUP BY oi.productItem.itemName
    		ORDER BY SUM(oi.quantity) DESC
    		""")
    		List<TopSellingProductDTO>
    		getTopSellingProducts();
    
    @Query("""
    		SELECT new com.DTO.TopCategoryDTO(
    		    oi.productItem.partMaster.category.categoryName,
    		    SUM(oi.quantity),
    		    SUM(oi.totalPrice)
    		)
    		FROM OrderItem oi
    		GROUP BY
    		oi.productItem.partMaster.category.categoryName
    		ORDER BY SUM(oi.quantity) DESC
    		""")
    		List<TopCategoryDTO>
    		getTopSellingCategories();
    @Query("""
    		SELECT new com.DTO.TopBrandDTO(
    		    oi.productItem.partBrand.brandName,
    		    SUM(oi.quantity),
    		    SUM(oi.totalPrice)
    		)
    		FROM OrderItem oi
    		GROUP BY
    		oi.productItem.partBrand.brandName
    		ORDER BY SUM(oi.quantity) DESC
    		""")
    		List<TopBrandDTO>
    		getTopSellingBrands();
    
    @Query("""
    		SELECT oi.productItem.id
    		FROM OrderItem oi
    		GROUP BY oi.productItem.id
    		""")
    		List<Long> getSoldProductIds();
    @Query("""
    		SELECT new com.DTO.ProfitReportDTO(
    		    SUM(oi.totalPrice),
    		    SUM(oi.productItem.costPrice * oi.quantity),
    		    SUM(oi.totalPrice)
    		      - SUM(oi.productItem.costPrice * oi.quantity)
    		)
    		FROM OrderItem oi
    		""")
    		ProfitReportDTO getProfitReport();
}