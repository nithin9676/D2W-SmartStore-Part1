package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.DTO.StoreRequestDTO;
import com.Entity.Store;
import com.Service.StoreService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping
    public String createStore( @Valid @RequestBody StoreRequestDTO requestDTO) {

        return storeService.createStore(requestDTO);
    }

    @GetMapping
    public List<Store> getAllStores() {

        return storeService.getAllStores();
    }
}