package com.sagaPattern.payments.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "userBalence")
public class UserBalence {
    @Id
    private int userId;
    private int price;

    public UserBalence() {
    }

    public UserBalence(int userId, int price) {
        this.userId = userId;
        this.price = price;
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
        return "UserBalence{" +
                "userId=" + userId +
                ", price=" + price +
                '}';
    }
}
