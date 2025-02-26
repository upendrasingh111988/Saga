package com.sagaPattern.commonDtos.dto;

import com.sagaPattern.commonDtos.event.OrderStatus;

public class OrderResponseDto {

    private Integer userId;
    private Integer productId;
    private Integer amount;
    private Integer orderId;
    private OrderStatus orderStatus;
}
