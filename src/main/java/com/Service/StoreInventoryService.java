package com.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.StoreInventoryRequestDTO;
import com.DTO.StoreInventoryResponseDTO;
import com.Entity.ProductItem;
import com.Entity.Store;
import com.Entity.StoreInventory;
import com.Repostory.ProductItemRepository;
import com.Repostory.StoreInventoryRepository;
import com.Repostory.StoreRepository;

@Service
public class StoreInventoryService {

    @Autowired
    private StoreInventoryRepository storeInventoryRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ProductItemRepository productItemRepository;

    public String addProductToStore(
            StoreInventoryRequestDTO requestDTO) {

        Store store =
            storeRepository
                .findById(requestDTO.getStoreId())
                .orElseThrow();

        ProductItem productItem =
            productItemRepository
                .findById(requestDTO.getProductId())
                .orElseThrow();

        StoreInventory existingInventory =
            storeInventoryRepository
                .findByStoreAndProductItem(
                    store,
                    productItem
                )
                .orElse(null);

        if(existingInventory != null)
        {

            existingInventory.setQuantity(

                existingInventory.getQuantity()
                +
                requestDTO.getQuantity()
            );

            existingInventory.setPurchasePrice(
                requestDTO.getPurchasePrice()
            );

            existingInventory.setSellingPrice(
                requestDTO.getSellingPrice()
            );

            storeInventoryRepository.save(
                existingInventory
            );

            return "Inventory Updated Successfully";
        }

        StoreInventory inventory =
            new StoreInventory();

        inventory.setStore(store);

        inventory.setProductItem(productItem);

        inventory.setQuantity(
            requestDTO.getQuantity()
        );

        inventory.setPurchasePrice(
            requestDTO.getPurchasePrice()
        );

        inventory.setSellingPrice(
            requestDTO.getSellingPrice()
        );

        inventory.setMinimumStock(5);

        inventory.setIsActive(true);

        storeInventoryRepository.save(inventory);

        return "Product Added To Inventory";
    }

    public List<StoreInventoryResponseDTO>
        getInventoryByStore(Long storeId) {

        Store store =
            storeRepository
                .findById(storeId)
                .orElseThrow();

        List<StoreInventory> inventoryList =
            storeInventoryRepository
                .findByStore(store);

        List<StoreInventoryResponseDTO> responseList =
            new ArrayList<>();

        for(StoreInventory inventory : inventoryList)
        {

            StoreInventoryResponseDTO responseDTO =
                new StoreInventoryResponseDTO();

            responseDTO.setInventoryId(
                inventory.getId()
            );

            responseDTO.setProductId(

                inventory
                    .getProductItem()
                    .getId()
            );

            responseDTO.setItemName(

                inventory
                    .getProductItem()
                    .getItemName()
            );

            responseDTO.setBrandName(

                inventory
                    .getProductItem()
                    .getPartBrand()
                    .getBrandName()
            );

            responseDTO.setPartNumber(

                inventory
                    .getProductItem()
                    .getPartNumber()
            );

            responseDTO.setDescription(

                inventory
                    .getProductItem()
                    .getDescription()
            );

            responseDTO.setSku(

                inventory
                    .getProductItem()
                    .getSku()
            );

            responseDTO.setCategoryName(

                inventory
                    .getProductItem()
                    .getPartMaster()
                    .getCategory()
                    .getCategoryName()
            );

            responseDTO.setProductMasterName(

                inventory
                    .getProductItem()
                    .getPartMaster()
                    .getMasterName()
            );

            responseDTO.setQuantity(
                inventory.getQuantity()
            );

            responseDTO.setSellingPrice(
                inventory.getSellingPrice()
            );

            responseDTO.setImage(

                inventory
                    .getProductItem()
                    .getMainImageUrl()
            );

            responseDTO.setInStock(

                inventory.getQuantity() > 0
            );

            responseList.add(responseDTO);
        }

        return responseList;
    }
}