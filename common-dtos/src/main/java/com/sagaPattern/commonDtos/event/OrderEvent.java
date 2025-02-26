package com.sagaPattern.commonDtos.event;

import com.sagaPattern.commonDtos.dto.OrderRequestDto;


import java.util.Date;
import java.util.UUID;

public class OrderEvent implements Event {

    private UUID eventId= UUID.randomUUID();
    private Date eventDate= new Date();
    private OrderRequestDto orderRequestDto;
    private OrderStatus orderStatus;

    public OrderEvent(OrderRequestDto orderRequestDto, OrderStatus orderStatus) {
        this.orderRequestDto = orderRequestDto;
        this.orderStatus = orderStatus;
    }

    @Override
    public UUID getEventId() {
        return eventId;
    }

    @Override
    public Date getDate() {
        return eventDate;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public OrderRequestDto getOrderRequestDto() {
        return orderRequestDto;
    }

    public void setOrderRequestDto(OrderRequestDto orderRequestDto) {
        this.orderRequestDto = orderRequestDto;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
