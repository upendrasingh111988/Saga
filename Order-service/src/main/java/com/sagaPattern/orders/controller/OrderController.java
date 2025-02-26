package com.sagaPattern.orders.controller;

import com.sagaPattern.commonDtos.dto.OrderRequestDto;
import com.sagaPattern.orders.entity.PurchaseOrder;
import com.sagaPattern.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public PurchaseOrder createOrder(@RequestBody OrderRequestDto dto){
       return orderService.createOrder(dto);
    }
    @GetMapping
    public List<PurchaseOrder> getAllOrders(){
        return orderService.getAllPurchaseOrder();
    }
}
