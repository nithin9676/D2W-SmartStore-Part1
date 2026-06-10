package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.VendorRequestDTO;
import com.Entity.Vendor;

import com.Repostory.VendorRepository;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    public String createVendor(
        VendorRequestDTO dto) {

        Vendor vendor =
            new Vendor();

        vendor.setVendorName(
            dto.getVendorName()
        );

        vendor.setPhone(
            dto.getPhone()
        );

        vendor.setEmail(
            dto.getEmail()
        );

        vendor.setGstNumber(
            dto.getGstNumber()
        );

        vendor.setAddress(
            dto.getAddress()
        );

        vendorRepository.save(
            vendor
        );

        return "Vendor Saved Successfully";
    }

    public List<Vendor> getAllVendors() {

        return vendorRepository.findAll();
    }
}