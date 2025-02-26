package com.sagaPattern.commonDtos.dto;


public class PayementRequestDto {

    private Integer userId;
    private Integer orderId;
    private Integer amount;

    public PayementRequestDto(Integer userId, Integer orderId, Integer amount) {
        this.userId = userId;
        this.orderId = orderId;
        this.amount = amount;
    }

    public PayementRequestDto() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PayementRequestDto{" +
                "userId=" + userId +
                ", orderId=" + orderId +
                ", amount=" + amount +
                '}';
    }
}
