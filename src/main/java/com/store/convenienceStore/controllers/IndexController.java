package com.store.convenienceStore.controllers;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.store.convenienceStore.models.Products;
import com.store.convenienceStore.services.ProductService;

@Controller
public class IndexController {

    @Autowired
    private ProductService productService;
    
    // Display the product page
    @GetMapping(value = {"/", "/home"})
    public String showProductPage(Model model, HttpSession session) {
        List<Products> products = productService.getAllProducts();
        model.addAttribute("products", products);
        
        List<Products> latestProducts = productService.getLatestProducts();
        model.addAttribute("latestProducts", latestProducts);

        // Check for user session and add to the model
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username);

        return "user/index";
    }
}
