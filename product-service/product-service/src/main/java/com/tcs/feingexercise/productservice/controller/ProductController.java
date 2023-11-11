package com.tcs.feingexercise.productservice.controller;

import com.tcs.feingexercise.productservice.entity.Product;
import com.tcs.feingexercise.productservice.repository.ProductRepository;
import com.tcs.feingexercise.productservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
//    @PostMapping
//    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
//        Product savedProduct = productService.saveProduct(product);
//        return ResponseEntity.ok(savedProduct);
//    }

    // Implement other CRUD APIs and possibly some APIs for querying
    @GetMapping(value = "/{id}")
    public Optional<Product> getProductById(@PathVariable("id") String id) {
        log.info("Retrieve Product by product Id");
        Optional<Product> optionalProduct = productService.getProductById(id);
        if(optionalProduct.isPresent()){
           return optionalProduct;
        }else
            return null;
    }
}