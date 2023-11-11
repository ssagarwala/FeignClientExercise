package com.tcs.feingexercise.productservice.service;

import com.tcs.feingexercise.productservice.entity.Product;
import com.tcs.feingexercise.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product>  getProductById(String id) {
        return productRepository.findById(id);
    }
}