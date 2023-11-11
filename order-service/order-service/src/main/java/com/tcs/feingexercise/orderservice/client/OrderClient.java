package com.tcs.feingexercise.orderservice.client;

import com.tcs.feingexercise.orderservice.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Indicates that this interface is a Feign client with the service ID 'order-service'
@FeignClient(name = "order-service")
public interface OrderClient {

    // Maps to /orders/{id} API of the order-service
    @GetMapping("/orders/{id}")
    Order getOrderById(@PathVariable("id") Long id);

    // Implement other required APIs
}