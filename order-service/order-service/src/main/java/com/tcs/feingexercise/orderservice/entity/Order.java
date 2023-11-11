package com.tcs.feingexercise.orderservice.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("orders")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
public class Order {
    @Id
    String id;
    int quantity;
    String productId;
    // Getter and Setters
}