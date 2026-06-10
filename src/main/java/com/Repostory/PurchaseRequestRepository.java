package com.Repostory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.PurchaseRequest;

public interface PurchaseRequestRepository
        extends JpaRepository<PurchaseRequest, Long> {

}