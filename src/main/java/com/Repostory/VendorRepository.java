package com.Repostory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.Vendor;

public interface VendorRepository
    extends JpaRepository<
        Vendor,
        Long> {

}