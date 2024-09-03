package com.store.convenienceStore.services;

import org.springframework.data.jpa.repository.JpaRepository;
import com.store.convenienceStore.models.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    // You can add custom methods here if needed
}
