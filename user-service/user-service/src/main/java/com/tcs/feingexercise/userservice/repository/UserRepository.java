package com.tcs.feingexercise.userservice.repository;

import com.tcs.feingexercise.userservice.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}