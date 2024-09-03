package com.store.convenienceStore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.convenienceStore.models.User;
import com.store.convenienceStore.services.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public boolean registerUser(String fullname, String email, String username, String password) {
        if (userRepository.existsByUsername(username)) {
            return false;
        }

        User user = new User();
        user.setFullname(fullname);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password); // WARNING: Storing plain text password

        userRepository.save(user);
        return true;
    }
    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
