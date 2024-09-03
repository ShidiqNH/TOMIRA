package com.store.convenienceStore.services;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.store.convenienceStore.models.Products;

@Repository

public interface ProductRepositories extends JpaRepository<Products, Long> {
    
    @Query("SELECT p FROM Products p ORDER BY p.createdAt DESC")
    List<Products> findTop10ByOrderByCreatedAtDesc(Pageable pageable);

    default List<Products> findLatest10Products() {
        return findTop10ByOrderByCreatedAtDesc(PageRequest.of(0, 10));
    }
    
    List<Products> findByCategory(String category);
}