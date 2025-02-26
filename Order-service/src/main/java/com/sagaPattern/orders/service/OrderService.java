package com.sagaPattern.orders.service;

import com.sagaPattern.commonDtos.dto.OrderRequestDto;
import com.sagaPattern.commonDtos.event.OrderStatus;
import com.sagaPattern.orders.entity.PurchaseOrder;
import com.sagaPattern.orders.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderStatusPublishers orderStatusPublishers;
    @Transactional
    public PurchaseOrder createOrder(OrderRequestDto dto) {
        PurchaseOrder order = orderRepository.save(convertDtoToEntity(dto));
        dto.setOrderId(order.getId());
        // produce kafaka event with status ORDER_CREATED
        orderStatusPublishers.publishOderEvent(dto,OrderStatus.ORDER_CREATED);
        return order;
    }
    public List<PurchaseOrder> getAllPurchaseOrder(){
      return   orderRepository.findAll();
    }

    private PurchaseOrder convertDtoToEntity(OrderRequestDto orderRequestDto){
        PurchaseOrder purchaseOrder= new PurchaseOrder();
        purchaseOrder.setProductId(orderRequestDto.getProductId());
        purchaseOrder.setOrderStatus(OrderStatus.ORDER_CREATED);
        purchaseOrder.setUserId(orderRequestDto.getUserId());
        return purchaseOrder;



    }
}
