package com.tcs.feingexercise.orderservice.controller;

import com.tcs.feingexercise.orderservice.entity.Order;
import com.tcs.feingexercise.orderservice.entity.Product;
import com.tcs.feingexercise.orderservice.exception.BadRequestException;
import com.tcs.feingexercise.orderservice.exception.InternalServerErrorException;
import com.tcs.feingexercise.orderservice.exception.ProductNotFoundException;
import com.tcs.feingexercise.orderservice.feign.ProductClient;
import com.tcs.feingexercise.orderservice.repository.OrderRepository;
import com.tcs.feingexercise.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.Optional;


@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        try {
            Order ordered = orderService.saveOrder(order);
            String orderedId = ordered.getId();
            return new ResponseEntity<>(orderedId, HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        } catch (InternalServerErrorException e) {
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (BadRequestException e) {
            return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}