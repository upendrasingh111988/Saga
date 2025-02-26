package com.sagaPattern.orders.service;

import com.sagaPattern.commonDtos.dto.OrderRequestDto;
import com.sagaPattern.commonDtos.event.OrderEvent;
import com.sagaPattern.commonDtos.event.OrderStatus;
import reactor.core.publisher.Sinks;

public class OrderStatusPublishers {
    private Sinks.Many<OrderEvent> orderSinks;

    public void publishOderEvent(OrderRequestDto orderRequestDto, OrderStatus orderStatus){
        OrderEvent orderEvent= new OrderEvent(orderRequestDto,orderStatus);
        orderSinks.tryEmitNext(orderEvent);

    }
}
