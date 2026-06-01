//package com.Repostory;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.Entity.Inventory_Details;
//
//public interface Inventory_Repository extends JpaRepository<Inventory_Details, Long>{
//	
//	Optional<Inventory_Details> findByStore_IdAndPartItem_Id(Long storeId,Long partId);
//	List<Inventory_Details> findByPartItem_Id(Long id);
//	List<Inventory_Details> findByStore_Id(Long storeId);
//	 List<Inventory_Details> findByStore_IdIn(List<Long> storeIds);
//
//}
