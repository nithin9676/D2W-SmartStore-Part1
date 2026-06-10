package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.DTO.VendorRequestDTO;
import com.Entity.Vendor;
import com.Service.VendorService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping
    public String createVendor(
        @RequestBody
        VendorRequestDTO dto) {

        return vendorService
            .createVendor(dto);
    }

    @GetMapping
    public List<Vendor> getAllVendors() {

        return vendorService
            .getAllVendors();
    }
}