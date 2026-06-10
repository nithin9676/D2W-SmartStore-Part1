package com.Repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.PurchaseRequest;
import com.Entity.PurchaseRequestItem;

public interface PurchaseRequestItemRepository extends JpaRepository< PurchaseRequestItem, Long> {

    List<PurchaseRequestItem>
    findByPurchaseRequest(
            PurchaseRequest purchaseRequest);
}