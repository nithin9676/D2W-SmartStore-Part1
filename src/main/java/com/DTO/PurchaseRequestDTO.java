package com.DTO;

import java.util.List;

public class PurchaseRequestDTO {

    private Long storeId;

    private List<PurchaseRequestItemDTO> items;

    public PurchaseRequestDTO() {
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public List<PurchaseRequestItemDTO> getItems() {
        return items;
    }

    public void setItems(
            List<PurchaseRequestItemDTO> items) {
        this.items = items;
    }
}