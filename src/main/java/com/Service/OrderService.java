package com.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.InvoiceItemDTO;
import com.DTO.InvoiceResponseDTO;
import com.DTO.OrderItemDTO;
import com.DTO.OrderRequestDTO;
import com.Entity.OrderItem;
import com.Entity.OrderMaster;
import com.Entity.ProductItem;
import com.Entity.Store;
import com.Entity.StoreInventory;
import com.Repostory.OrderItemRepository;
import com.Repostory.OrderMasterRepository;
import com.Repostory.ProductItemRepository;
import com.Repostory.StoreInventoryRepository;
import com.Repostory.StoreRepository;

@Service
public class OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private StoreInventoryRepository storeInventoryRepository;

    public Long placeOrder(OrderRequestDTO requestDTO) {

        OrderMaster orderMaster = new OrderMaster();

        orderMaster.setCustomerName(requestDTO.getCustomerName());
        orderMaster.setPhone(requestDTO.getPhone());
        orderMaster.setAddress(requestDTO.getAddress());
        orderMaster.setPaymentMethod(requestDTO.getPaymentMethod());
        orderMaster.setTotalAmount(requestDTO.getTotalAmount());
        System.out.println(
        	    "NAME = " +
        	    requestDTO.getCustomerName()
        	);

        	System.out.println(
        	    "PHONE = " +
        	    requestDTO.getPhone()
        	);

        OrderMaster savedOrder = orderMasterRepository.save(orderMaster);
        System.out.println(
        	    "STORE ID = " +
        	    requestDTO.getStoreId()
        	);
        Store store =
        	    storeRepository
        	        .findById(
        	            requestDTO.getStoreId()
        	        )
        	        .orElseThrow();
        System.out.println(
        	    "SAVED NAME = " +
        	    savedOrder.getCustomerName()
        	);

        	System.out.println(
        	    "SAVED PHONE = " +
        	    savedOrder.getPhone()
        	);

        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemDTO itemDTO : requestDTO.getItems()) {

            ProductItem product = productItemRepository.findById(itemDTO.getProductId()).orElseThrow();
            StoreInventory inventory =
            	    storeInventoryRepository
            	        .findByStoreAndProductItem(
            	            store,
            	            product
            	        )
            	        .orElseThrow();

            	if(
            	    inventory.getQuantity()
            	    <
            	    itemDTO.getQuantity()
            	)
            	{
            	    throw new RuntimeException(
            	        "Insufficient Stock"
            	    );
            	}

            	inventory.setQuantity(

            	    inventory.getQuantity()

            	    -

            	    itemDTO.getQuantity()
            	);

            	storeInventoryRepository
            	    .save(inventory);

            OrderItem orderItem = new OrderItem();

            orderItem.setOrderMaster(savedOrder);
            orderItem.setProductItem(product);
            orderItem.setQuantity(itemDTO.getQuantity());
            orderItem.setSellingPrice(itemDTO.getSellingPrice());
            orderItem.setTotalPrice(itemDTO.getTotalPrice());

            orderItems.add(orderItem);
        }

        orderItemRepository.saveAll(orderItems);

        return savedOrder.getId();
    }
    
    public InvoiceResponseDTO
    getInvoice(Long orderId) {

    OrderMaster orderMaster =
        orderMasterRepository
            .findById(orderId)
            .orElseThrow();

    List<OrderItem> orderItems =
        orderItemRepository
            .findByOrderMaster(
                orderMaster
            );

    InvoiceResponseDTO response =
        new InvoiceResponseDTO();

    response.setOrderId(
        orderMaster.getId()
    );

    response.setCustomerName(
        orderMaster.getCustomerName()
    );

    response.setPhone(
        orderMaster.getPhone()
    );

    response.setPaymentMethod(
        orderMaster.getPaymentMethod()
    );

    response.setTotalAmount(
        orderMaster.getTotalAmount()
    );

    response.setOrderDate(
        orderMaster.getOrderDate()
    );

    List<InvoiceItemDTO> items =
        new ArrayList<>();

    for(OrderItem item : orderItems)
    {
        InvoiceItemDTO dto =
            new InvoiceItemDTO();

        dto.setItemName(

            item.getProductItem()
                .getItemName()
        );

        dto.setQuantity(
            item.getQuantity()
        );

        dto.setSellingPrice(
            item.getSellingPrice()
        );

        dto.setTotalPrice(
            item.getTotalPrice()
        );

        items.add(dto);
    }

    response.setItems(items);

    return response;
}
}