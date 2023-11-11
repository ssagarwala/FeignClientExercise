package com.tcs.feingexercise.productservice.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("products")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Product {
    @Id
    String id;
    String name;
    double price;
    // Getter and Setters
}