package com.Repostory;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Store;
import com.Entity.StoreInventory;
import com.DTO.LowStockItemDTO;
import com.Entity.ProductItem;

@Repository
public interface StoreInventoryRepository extends JpaRepository<StoreInventory, Long> {

    List<StoreInventory> findByStore(Store store);

    Optional<StoreInventory> findByStoreAndProductItem(Store store, ProductItem productItem);
    @Query(
    	    "SELECT COALESCE(SUM(s.quantity),0) " +
    	    "FROM StoreInventory s"
    	)
    	Long getTotalStockQuantity();
    
    @Query(
    	    "SELECT COUNT(s) " +
    	    "FROM StoreInventory s " +
    	    "WHERE s.quantity <= 5"
    	)
    	Long getLowStockItems();
    @Query(
    	    "SELECT COUNT(s) " +
    	    "FROM StoreInventory s " +
    	    "WHERE s.quantity = 0"
    	)
    	Long getOutOfStockItems();
    @Query("""
    		SELECT COUNT(s)
    		FROM StoreInventory s
    		""")
    		Long getTotalProducts();
    @Query("""
    		SELECT COUNT(s)
    		FROM StoreInventory s
    		WHERE s.quantity > s.minimumStock
    		""")
    		Long getInStockItems();
    @Query("""
    		SELECT COUNT(s)
    		FROM StoreInventory s
    		WHERE s.quantity <= s.minimumStock
    		""")
    		Long getTotalLowStockItems();
    @Query("""
    		SELECT COUNT(s)
    		FROM StoreInventory s
    		WHERE s.quantity <= 2
    		""")
    		Long getCriticalItems();
    @Query("""
    		SELECT new com.DTO.LowStockItemDTO(
    		s.id,
    		s.productItem.itemName,
    		s.store.storeName,
    		s.quantity,
    		s.minimumStock,
    		CASE
    		WHEN s.quantity = 0 THEN 'OUT OF STOCK'
    		ELSE 'LOW STOCK'
    		END
    		)
    		FROM StoreInventory s
    		WHERE s.quantity <= s.minimumStock
    		""")
    		List<LowStockItemDTO> getLowStockItems1();
    
}