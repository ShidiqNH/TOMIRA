package com.store.convenienceStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import com.store.convenienceStore.models.Products;

import com.store.convenienceStore.services.ProductService;
import com.store.convenienceStore.services.TransactionService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SingleProductController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/product/{id}")
    public String showSingleProductPage(@PathVariable("id") Long id, Model model, HttpSession session) {
        Products product = productService.getProductById(id);
        model.addAttribute("product", product);
        
        // Check for user session and add to the model
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username);
        
        return "singularProduct/index";
    }
    
}

