package com.sagaPattern.payments.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_transction")
public class UserTransction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private int userId;
    private int price;

    public UserTransction(Integer orderId, int userId, int price) {
        this.orderId = orderId;
        this.userId = userId;
        this.price = price;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "UserTransction{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", price=" + price +
                '}';
    }
}
