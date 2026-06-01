//  package com.Controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.DTO.StoreResponse_Dto;
//import com.Entity.Inventory_Details;
//import com.Service.Inventory_Service;
//@CrossOrigin(origins="http://localhost:5173")
//@RestController
//public class Inventory_controller {
//	
//	@Autowired
//	Inventory_Service inventoryService;
//	
//	@PostMapping("/inventory")
//	public String insertingInventoryDetails(@RequestBody Inventory_Details invdetails)
//	{
//		 return inventoryService.insertingInventoryDetails(invdetails);
//	}
//	@GetMapping("/neareststore")
//	 public List<StoreResponse_Dto> getNearestStore(@RequestParam("partId")Long partid,@RequestParam("pincode")String pincode)
//	 {
//		 return inventoryService.getNearestStore(partid, pincode);
//	 }
//	 
///*	----------- getting all inventory stock------------------------------*/
//	 
//	 @GetMapping("/admin/inventory")
//	 public List<Inventory_Details> getAllInventory()
//	 {
//		 return inventoryService.getAllInventory();
//	 }
//	 @PostMapping("/admin/updateinventory")
//	 public String updateInventory(@RequestParam("inventoryId") Long inventoryId,@RequestParam("quantity") Long quantity) {
//		 return inventoryService.updateInventory(inventoryId, quantity);
//		 
//	 }
//	 
//	@GetMapping("/admin/inventory/store")
//	 public List<Inventory_Details> getInventoryByStore(@RequestParam("storeId") Long id)
//	 {
//		 return inventoryService.getInventorybyStore(id);
//	 }
//	
//
//	 @GetMapping("/admin/inventory/access")
//	 public List<Inventory_Details> getInventoryByAdminAccess(
//	         @RequestParam("adminId") Long adminId)
//	 {
//	     return inventoryService.getInventoryByAdminAccess(adminId);
//	 }
//	 
//	 
//}
