package com.sagaPattern.orders.config;

import com.sagaPattern.commonDtos.event.PayementEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class EventConsumerConfig {
    @Autowired
    private OderStatusUpdateHandler handler;

    @Bean
    public Consumer<PayementEvent> payementEventConsumer(){
        // listen payment event topic
        //will check payment Status
        // if payment is completed -> order complete
        // if payment status is failed -> cancel order
        return (payment)->handler.updateOrder(payment.getPayementRequestDto().getOrderId(),
            po->{
            po.setPayementStatus(payment.getPayementStatus());
            }
                );
    }
}
