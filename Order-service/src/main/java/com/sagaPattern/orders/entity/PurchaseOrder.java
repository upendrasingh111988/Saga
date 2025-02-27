package com.sagaPattern.orders.entity;

import com.sagaPattern.commonDtos.event.OrderStatus;
import com.sagaPattern.commonDtos.event.PayementStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "purchase_order")

public class PurchaseOrder {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer price;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @Enumerated(EnumType.STRING)
    private PayementStatus payementStatus;

    public PurchaseOrder() {
    }

    public PurchaseOrder(Integer id, Integer userId, Integer productId, Integer price, OrderStatus orderStatus, PayementStatus payementStatus) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.price = price;
        this.orderStatus = orderStatus;
        this.payementStatus = payementStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public PayementStatus getPayementStatus() {
        return payementStatus;
    }

    public void setPayementStatus(PayementStatus payementStatus) {
        this.payementStatus = payementStatus;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", price=" + price +
                ", orderStatus=" + orderStatus +
                ", payementStatus=" + payementStatus +
                '}';
    }
}
