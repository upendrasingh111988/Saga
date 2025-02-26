package com.sagaPattern.commonDtos.event;

import com.sagaPattern.commonDtos.dto.PayementRequestDto;


import java.util.Date;
import java.util.UUID;

public class PayementEvent implements Event{

    private UUID eventId= UUID.randomUUID();
    private Date eventDate= new Date();
    private PayementRequestDto payementRequestDto;
    private PayementStatus payementStatus;

    public PayementEvent(PayementRequestDto payementRequestDto, PayementStatus payementStatus) {
        this.payementRequestDto = payementRequestDto;
        this.payementStatus = payementStatus;
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

    public PayementRequestDto getPayementRequestDto() {
        return payementRequestDto;
    }

    public void setPayementRequestDto(PayementRequestDto payementRequestDto) {
        this.payementRequestDto = payementRequestDto;
    }

    public PayementStatus getPayementStatus() {
        return payementStatus;
    }

    public void setPayementStatus(PayementStatus payementStatus) {
        this.payementStatus = payementStatus;
    }

    public PayementEvent(UUID eventId, Date eventDate, PayementRequestDto payementRequestDto, PayementStatus payementStatus) {
        this.eventId = eventId;
        this.eventDate = eventDate;
        this.payementRequestDto = payementRequestDto;
        this.payementStatus = payementStatus;
    }
}
