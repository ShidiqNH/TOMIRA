package com.store.convenienceStore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.convenienceStore.models.Products;
import com.store.convenienceStore.services.ProductRepositories;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepositories productRepository;

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Products getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    
    public List<Products> getLatestProducts() {
        return productRepository.findLatest10Products();
    }
    
    public List<Products> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }
    public void saveProduct(Products product) {
        productRepository.save(product);
    }
}
