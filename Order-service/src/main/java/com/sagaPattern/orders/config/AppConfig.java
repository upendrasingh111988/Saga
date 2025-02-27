package com.sagaPattern.orders.config;

import com.sagaPattern.orders.service.OrderStatusPublishers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public OrderStatusPublishers orderStatusPublishers() {
        return new OrderStatusPublishers();
    }
}
