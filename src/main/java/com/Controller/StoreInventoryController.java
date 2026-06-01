package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.DTO.StoreInventoryRequestDTO;
import com.DTO.StoreInventoryResponseDTO;

import com.Service.StoreInventoryService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/store-inventory")
public class StoreInventoryController {

    @Autowired
    private StoreInventoryService storeInventoryService;

    @PostMapping("/add-product")
    public String addProductToStore(@RequestBody StoreInventoryRequestDTO requestDTO) {

        return storeInventoryService.addProductToStore(requestDTO);
    }
    
    @GetMapping("/store/{storeId}")
    public List<StoreInventoryResponseDTO> getInventoryByStore( @PathVariable("storeId") Long storeId) {

        return storeInventoryService .getInventoryByStore(storeId);
    }
}