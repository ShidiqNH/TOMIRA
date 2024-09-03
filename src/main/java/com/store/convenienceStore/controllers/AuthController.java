package com.store.convenienceStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.servlet.http.HttpSession;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import com.store.convenienceStore.models.User;
import com.store.convenienceStore.services.AuthService;
import com.store.convenienceStore.services.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@ModelAttribute RegisterRequest request) {
        if (authService.registerUser(request.getFullname(), request.getEmail(), request.getUsername(), request.getPassword())) {
            return ResponseEntity.ok("Registration successful");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
        }
    }
    
    

    @Autowired
    private UserRepository UserRepository;
    @GetMapping("/checkUsername")
    @ResponseBody
    public ResponseEntity<Map<String, Boolean>> checkUsername(@RequestParam String username) {
        boolean exists = authService.usernameExists(username);
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpSession session) {
        if (authService.loginUser(request.getUsername(), request.getPassword())) {
            // Retrieve the logged-in user from the database
            User user = UserRepository.findByUsername(request.getUsername());
        
            // Set session attributes
            session.setAttribute("username", request.getUsername());
            session.setAttribute("userId", user.getId()); // Access the id of the retrieved user
        
            URI location = UriComponentsBuilder.fromPath("/home").build().toUri();
            return ResponseEntity.status(HttpStatus.FOUND).location(location).build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/login")).build();
    }

    // Request DTO classes
    public static class RegisterRequest {
        private String fullname;
        private String email;
        private String username;
        private String password;

        // Getters and setters
        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class LoginRequest {
        private String username;
        private String password;

        // Getters and setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
