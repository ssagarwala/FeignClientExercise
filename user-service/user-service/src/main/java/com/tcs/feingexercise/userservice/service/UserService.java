package com.tcs.feingexercise.userservice.service;

import com.tcs.feingexercise.userservice.entity.User;
import com.tcs.feingexercise.userservice.exception.UserNotFoundException;
import com.tcs.feingexercise.userservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    public User createUser(User user) {
        log.info("Creating user with username: {}", user.getUsername());
        User createdUser = userRepository.save(user);
        log.info("User created: {}", createdUser);
        return createdUser;
    }

    public User findUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}