package com.tcs.feingexercise.orderservice.service;

import com.tcs.feingexercise.orderservice.entity.Order;
import com.tcs.feingexercise.orderservice.entity.Product;
import com.tcs.feingexercise.orderservice.exception.ProductNotFoundException;
import com.tcs.feingexercise.orderservice.feign.ProductClient;
import com.tcs.feingexercise.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductClient productClient;

    public Order saveOrder(Order order) {
        Optional<Product> optionalProduct = productClient.getProductById(order.getProductId());
        if (optionalProduct.isPresent()) {
            Order ordered = orderRepository.save(order);
            return ordered;
        } else
            throw new ProductNotFoundException("Product NOT found exception");
    }
}