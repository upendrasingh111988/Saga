package com.sagaPattern.payments.config;

import com.sagaPattern.commonDtos.event.OrderEvent;
import com.sagaPattern.commonDtos.event.OrderStatus;
import com.sagaPattern.commonDtos.event.PayementEvent;
import com.sagaPattern.payments.service.PayementService;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Configuration
public class PayementConsumerConfig {

    @Autowired
    private PayementService payementService;

    public Function<Flux<OrderEvent>,Flux<PayementEvent>> payementProcessor(){
        return orderEventFlux -> orderEventFlux.flatMap(this::processPayment);
    }

    private Mono<PayementEvent> processPayment(OrderEvent orderEvent) {
        // get the user id
        // check the balence avability
        //if balence is sufficcient then payement completed and amount deducted
        // if balence is not sufficient then cancel the order event and update the amount in db
        if (OrderStatus.ORDER_CREATED.equals(orderEvent.getOrderStatus())) {
            return Mono.fromSupplier(()->this.payementService.newOrderEvent(orderEvent));
        }else {
            return Mono.fromSupplier(()->this.payementService.cancelOrderEvent());
        }
    }
}
