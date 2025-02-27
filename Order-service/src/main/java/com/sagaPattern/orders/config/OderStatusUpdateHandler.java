package com.sagaPattern.orders.config;

import com.sagaPattern.commonDtos.dto.OrderRequestDto;
import com.sagaPattern.commonDtos.event.OrderStatus;
import com.sagaPattern.commonDtos.event.PayementStatus;
import com.sagaPattern.orders.entity.PurchaseOrder;
import com.sagaPattern.orders.repository.OrderRepository;
import com.sagaPattern.orders.service.OrderStatusPublishers;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class OderStatusUpdateHandler {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderStatusPublishers orderStatusPublishers;
    @Transactional
    public void updateOrder(int id, Consumer<PurchaseOrder>consumer){
        orderRepository.findById(id).ifPresent(
                consumer.andThen(this::updateOrder));

    }

    private void updateOrder(PurchaseOrder purchaseOrder) {

    boolean isPaymentCompleted = PayementStatus.PAYEMENTS_COMPLETED.equals(purchaseOrder.getPayementStatus());
      OrderStatus orderStatus=  isPaymentCompleted? OrderStatus.ORDER_COMPLETED:OrderStatus.ORDER_CANCELLED;
        purchaseOrder.setOrderStatus(orderStatus);
        if (!isPaymentCompleted){
            orderStatusPublishers.publishOderEvent(convertEntityToDto(purchaseOrder),orderStatus);
        }
    }
    public OrderRequestDto convertEntityToDto(PurchaseOrder purchaseOrder){
    OrderRequestDto orderRequestDto= new OrderRequestDto();
    orderRequestDto.setOrderId(purchaseOrder.getId());
    orderRequestDto.setUserId(purchaseOrder.getUserId());
    orderRequestDto.setAmount(purchaseOrder.getPrice());
    orderRequestDto.setProductId(purchaseOrder.getProductId());
    return orderRequestDto;
    }
}
