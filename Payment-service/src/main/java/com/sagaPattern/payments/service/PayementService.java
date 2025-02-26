package com.sagaPattern.payments.service;

import com.sagaPattern.commonDtos.event.OrderEvent;
import com.sagaPattern.commonDtos.event.PayementEvent;
import com.sagaPattern.payments.respository.UserBalenceRepository;
import com.sagaPattern.payments.respository.UserTransctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayementService {
    @Autowired
    private UserBalenceRepository userBalenceRepository;
    @Autowired
    private UserTransctionRepository userTransctionRepository;
    public PayementEvent newOrderEvent(OrderEvent orderEvent) {
        return null;
    }

    public PayementEvent cancelOrderEvent() {
        return null;
    }
}
