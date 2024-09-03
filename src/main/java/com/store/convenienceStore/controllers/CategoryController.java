package com.store.convenienceStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.convenienceStore.models.Products;
import com.store.convenienceStore.services.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CategoryController {

    @Autowired
    private ProductService productService;

    // Display products by category
    @GetMapping("/products/category")
    public String showProductsByCategory(@RequestParam("category") String category, Model model, HttpSession session) {
        List<Products> products = productService.getProductsByCategory(category);
        model.addAttribute("products", products);

        // Check for user session and add to the model
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username);

        return "user/product";
    }
}
