package com.store.convenienceStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    // Display the contact page
    @GetMapping("/contact")
    public String showContactPage(Model model) {
        // Add any necessary data to the model
        return "user/ContactUs"; // Return the name of the Thymeleaf template (contact.html)
    }
}
