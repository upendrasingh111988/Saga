package com.sagaPattern.orders.repository;

import com.sagaPattern.orders.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<PurchaseOrder,Integer> {
}
