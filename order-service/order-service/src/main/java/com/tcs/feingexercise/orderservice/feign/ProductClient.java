package com.tcs.feingexercise.orderservice.feign;

import com.tcs.feingexercise.orderservice.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "product-service", url = "http://localhost:8081")
public interface ProductClient {
//    @GetMapping(value = "/product", headers = "Authorization=Bearer my_token")
//    String getProduct();

    // Or, you can pass the header value dynamically
    @GetMapping("/products/{id}")
    Optional<Product> getProductById(@PathVariable("id") String id);
}
