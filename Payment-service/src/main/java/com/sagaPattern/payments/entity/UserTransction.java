package com.sagaPattern.payments.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTransction {
    @Id
    private Integer orderId;
    private int userId;
    private int price;
}
