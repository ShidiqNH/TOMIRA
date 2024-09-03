package com.store.convenienceStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String showRegisPage() {
        return "user/register"; // This will return the login.html page
    }
}
