package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.DTO.InvoiceResponseDTO;
import com.DTO.OrderRequestDTO;
import com.Service.OrderService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Long placeOrder(
            @RequestBody OrderRequestDTO requestDTO) {

        System.out.println(requestDTO.getCustomerName());

        System.out.println(requestDTO.getItems());

        return orderService.placeOrder(requestDTO);
    }
    @GetMapping("/{orderId}")
    public InvoiceResponseDTO getInvoice(  @PathVariable("orderId") Long orderId ) {

        return orderService .getInvoice(orderId);
    }
}