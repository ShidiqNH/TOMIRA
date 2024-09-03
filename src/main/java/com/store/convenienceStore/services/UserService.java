package com.store.convenienceStore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.store.convenienceStore.models.User;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        logger.info("Querying user by username: {}", username);
        User user = userRepository.findByUsername(username);
        if (user != null) {
            logger.info("User found: {}", user);
            return user;
        } else {
            logger.info("User not found for username: {}", username);
            return null;
        }
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
