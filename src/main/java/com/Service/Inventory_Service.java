//package com.Service;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.DTO.StoreResponse_Dto;
//import com.Entity.Inventory_Details;
//import com.Entity.PartItem_Details;
//import com.Entity.Store_Details;
//import com.Repostory.Inventory_Repository;
//import com.Repostory.Partitem_Repository;
//import com.Repostory.Store_Repository;
//
//@Service
//public class Inventory_Service {
//
//	@Autowired
//	Inventory_Repository inventoryRepository;
//
//	@Autowired
//	Store_Repository storeRepository;
//
//	@Autowired
//	Partitem_Repository partitemRepository;
//	
//	@Autowired
//	AdminUser_Service adminUserService;
//
//	public String insertingInventoryDetails(Inventory_Details indetails) {
//
//		// 1. null check for whole object
//		if (indetails == null) {
//			return "Inventory details are required";
//		}
//
//		// 2. null check for store object and part item object
//		if (indetails.getStore() == null || indetails.getPartItem() == null) {
//			return "Store and PartItem details are required";
//		}
//
//		// 3. id check
//		if (indetails.getStore().getId() == null || indetails.getPartItem().getId() == null) {
//			return "Store id and PartItem id are required";
//		}
//
//		// 4. quantity null check
//		if (indetails.getQuantity() == null) {
//			return "Quantity is required";
//		}
//
//		// 5. quantity negative check
//		if (indetails.getQuantity() < 0) {
//			return "Invalid quantity";
//		}
//
//		// 6. fetch store by id
//		Optional<Store_Details> storeAvailable =
//				storeRepository.findById(indetails.getStore().getId());
//
//		if (storeAvailable.isEmpty()) {
//			return "Store not found";
//		}
//
//		// 7. fetch part item by id
//		Optional<PartItem_Details> partItemAvailable =
//				partitemRepository.findById(indetails.getPartItem().getId());
//
//		if (partItemAvailable.isEmpty()) {
//			return "PartItem not found";
//		}
//		Long id=indetails.getStore().getId();
//		Long partid=indetails.getPartItem().getId();
//		// 8. duplicate check: same store + same part item
//		Optional<Inventory_Details> duplicate =inventoryRepository.findByStore_IdAndPartItem_Id(id, partid);
//
//		if (duplicate.isPresent()) {
//			Inventory_Details existing =duplicate.get();
//			Long oldqty=existing.getQuantity();
//			if(oldqty==null)
//			{
//				oldqty=0L;
//			}
//			existing.setQuantity(oldqty+indetails.getQuantity());
//			inventoryRepository.save(existing);
//			return "stock Updated";
//			
//		}
//
//		// 9. set DB-managed objects before save
//		indetails.setStore(storeAvailable.get());
//		indetails.setPartItem(partItemAvailable.get());
//
//		// 10. save inventory
//		inventoryRepository.save(indetails);
//
//		return "Inventory details inserted successfully";
//	}
//	
//	
//	public List<StoreResponse_Dto> productAvailbiltyViewer(Long partitemId)
//	{
//		List<StoreResponse_Dto>result=new ArrayList<StoreResponse_Dto>();
//		if(partitemId==null)
//		{
//			return new ArrayList<StoreResponse_Dto>();
//		}
//		Optional<PartItem_Details>partdetails=partitemRepository.findById(partitemId);
//		if(partdetails.isEmpty())
//		{
//			return new ArrayList<StoreResponse_Dto>();
//		}
//		
//		List<Inventory_Details>inventorydetails=inventoryRepository.findByPartItem_Id(partdetails.get().getId());
//		if(inventorydetails.isEmpty())
//		{
//			return new ArrayList<StoreResponse_Dto>();
//		}
//		for (Inventory_Details inventory_Details : inventorydetails) {
//			Store_Details store=inventory_Details.getStore();
//			Long qunatity=inventory_Details.getQuantity();
//			String storeName=store.getStoreName();
//			String city=store.getCity();
//			String pincode=store.getPincode();
//			String stockStatus;
//			if(qunatity>0)
//			{
//				stockStatus="In_Stock";
//			}
//			else
//			{
//				stockStatus="Out Of Stock";
//			}
//			StoreResponse_Dto dto=new StoreResponse_Dto();
//			dto.setStoreName(storeName);
//			dto.setQuantity(qunatity);
//			dto.setCity(city);
//			dto.setPincode(pincode);
//			dto.setStockstatus(stockStatus);
//			result.add(dto);
//			
//		}
//		return  result;
//	}
//	
//	public List<StoreResponse_Dto> getNearestStore(Long id, String pincode) {
//
//	    List<StoreResponse_Dto> result = new ArrayList<>();
//
//	  
//	    if (id == null || pincode == null || pincode.isBlank()) {
//	        return result;
//	    }
//
//	 
//	    Long userpincode;
//	    try {
//	        userpincode = Long.parseLong(pincode.trim());
//	    } catch (Exception e) {
//	        return result;
//	    }
//
//	   
//	    Optional<PartItem_Details> exist = partitemRepository.findById(id);
//	    if (exist.isEmpty()) {
//	        return result;
//	    }
//
//	
//	    List<Inventory_Details> inventorydetails =
//	            inventoryRepository.findByPartItem_Id(id);
//
//	    if (inventorydetails.isEmpty()) {
//	        return result;
//	    }
//
//	 
//	    for (Inventory_Details inventory : inventorydetails) {
//
//	        Store_Details store = inventory.getStore();
//
//	  
//	        if (store == null || store.getPincode() == null || store.getPincode().isBlank()) {
//	            continue;
//	        }
//
//	        Long quantity = inventory.getQuantity();
//
//	    
//	        if (quantity == null) {
//	            quantity = 0L;
//	        }
//
//	        
//	        String stockstatus;
//	        if (quantity > 0) {
//	            stockstatus = "IN_STOCK";
//	        } else {
//	            stockstatus = "OUT_OF_STOCK";
//	        }
//
//	        
//	        Long storepincode;
//	        try {
//	            storepincode = Long.parseLong(store.getPincode().trim());
//	        } catch (Exception e) {
//	            continue;
//	        }
//
//	      
//	        long difference = Math.abs(storepincode - userpincode);
//
//	        StoreResponse_Dto dto = new StoreResponse_Dto();
//	        dto.setStoreID(store.getId());
//	        dto.setStoreName(store.getStoreName());
//	        dto.setCity(store.getCity());
//	        dto.setPincode(store.getPincode());
//	        dto.setQuantity(quantity);
//	        dto.setStockstatus(stockstatus);
//	        dto.setPincodeDifference(difference);
//
//	        result.add(dto);
//	    }
//
//	   
//	    result.sort((a, b) -> {
//
//	        boolean aInStock = a.getQuantity() > 0;
//	        boolean bInStock = b.getQuantity() > 0;
//
//	        if (aInStock && !bInStock) {
//	            return -1;
//	        }
//	        if (!aInStock && bInStock) {
//	            return 1;
//	        }
//
//	        return a.getPincodeDifference().compareTo(b.getPincodeDifference());
//	    });
//
//	    return result;
//	}
//	
//	
//	public List<Inventory_Details> getAllInventory()
//	{
//		return inventoryRepository.findAll();
//	}
//	
//	public String updateInventory(Long inventoryId, Long quantity)
//	
//	{
//		
//		if(inventoryId==null||quantity==null || quantity<0)
//		{
//			return "invaild Data";
//		}
//		
//		Optional<Inventory_Details> inventory=inventoryRepository.findById(inventoryId);
//		if(inventory.isEmpty())
//		{
//			return "Inventory not found";
//		}
//		Inventory_Details inven=inventory.get();
//		inven.setQuantity(quantity);
//		inventoryRepository.save(inven);
//		return "inventory Updated";
//		
//	}
//	
//	public List<Inventory_Details> getInventorybyStore(Long storeId)
//	{
//		if(storeId==null)
//		{
//			return new ArrayList<>();
//		}
//		return inventoryRepository.findByStore_Id(storeId);
//	}
//	
//	public List<Inventory_Details> getInventoryByAdminAccess(Long adminId) {
//
//	    if (adminId == null) {
//	        return new ArrayList<>();
//	    }
//
//	    List<Store_Details> accessibleStores =
//	            adminUserService.getAccessibleStores(adminId);
//
//	    if (accessibleStores == null || accessibleStores.isEmpty()) {
//	        return new ArrayList<>();
//	    }
//
//	    List<Long> storeIds = new ArrayList<>();
//
//	    for (Store_Details store : accessibleStores) {
//	        if (store != null && store.getId() != null) {
//	            storeIds.add(store.getId());
//	        }
//	    }
//
//	    if (storeIds.isEmpty()) {
//	        return new ArrayList<>();
//	    }
//
//	    return inventoryRepository.findByStore_IdIn(storeIds);
//	}
//}