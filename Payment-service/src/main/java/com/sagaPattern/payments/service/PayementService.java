package com.sagaPattern.payments.service;

import com.sagaPattern.commonDtos.dto.OrderRequestDto;
import com.sagaPattern.commonDtos.dto.PayementRequestDto;
import com.sagaPattern.commonDtos.event.OrderEvent;
import com.sagaPattern.commonDtos.event.PayementEvent;
import com.sagaPattern.commonDtos.event.PayementStatus;
import com.sagaPattern.payments.entity.UserBalence;
import com.sagaPattern.payments.entity.UserTransction;
import com.sagaPattern.payments.respository.UserBalenceRepository;
import com.sagaPattern.payments.respository.UserTransctionRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import jakarta.transaction.UserTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PayementService {
    @Autowired
    private UserBalenceRepository userBalenceRepository;
    @Autowired
    private UserTransctionRepository userTransctionRepository;

    @PostConstruct
    public void initUserBalenceInDb(){
        userBalenceRepository.saveAll(Stream.of(
                new UserBalence(101,5000),
                new UserBalence(102,9000),
                new UserBalence(105,8000),
                new UserBalence(107,7000)).collect(Collectors.toList()));
    }
    @Transactional
    public PayementEvent newOrderEvent(OrderEvent orderEvent) {
        OrderRequestDto orderRequestDto= new OrderRequestDto();
        PayementRequestDto payementRequestDto= new PayementRequestDto(orderRequestDto.getUserId(),
                orderRequestDto.getOrderId(),orderRequestDto.getAmount());
    return userBalenceRepository.findById(orderRequestDto.getUserId())
                .filter(ub->ub.getPrice()>orderRequestDto.getAmount())
                .map(ub -> {
                    ub.setPrice(ub.getPrice()-orderRequestDto.getAmount());
                            userTransctionRepository.save(

                                    new UserTransction(orderRequestDto.getOrderId(),
                                            orderRequestDto.getUserId(),orderRequestDto.getAmount()
                                            )
                            );
                            return new PayementEvent(payementRequestDto, PayementStatus.PAYEMENTS_COMPLETED);
                }).orElse(new PayementEvent(payementRequestDto,PayementStatus.PAYEMENT_FAILED));

    }

    @Transactional
    public void cancelOrderEvent(OrderEvent orderEvent) {
        userTransctionRepository.findById(orderEvent.getOrderRequestDto().getOrderId())
                .ifPresent(ut-> {

                    userTransctionRepository.delete(ut);
                    userTransctionRepository.findById(
                            ut.getUserId()).ifPresent(ub->ub.setPrice(ub.getPrice()+ ut.getPrice()));
                });

    }
}
