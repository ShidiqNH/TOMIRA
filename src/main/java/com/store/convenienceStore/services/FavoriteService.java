package com.store.convenienceStore.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.store.convenienceStore.models.Favorite;
import com.store.convenienceStore.models.FavoriteDto;
import com.store.convenienceStore.services.FavoriteRepository;

@Service
@Transactional
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public List<FavoriteDto> getAllFavorites() {
        List<Favorite> favorites = favoriteRepository.findAll();
        return favorites.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public FavoriteDto getFavoriteById(Integer id) {
        Optional<Favorite> optionalFavorite = favoriteRepository.findById(id);
        return optionalFavorite.map(this::convertToDto).orElse(null);
    }

    public FavoriteDto createFavorite(FavoriteDto favoriteDto) {
        Favorite favorite = convertToEntity(favoriteDto);
        Favorite savedFavorite = favoriteRepository.save(favorite);
        return convertToDto(savedFavorite);
    }

    public FavoriteDto updateFavorite(Integer id, FavoriteDto favoriteDto) {
        if (!favoriteRepository.existsById(id)) {
            return null;
        }
        Favorite favorite = convertToEntity(favoriteDto);
        favorite.setId(id);
        Favorite updatedFavorite = favoriteRepository.save(favorite);
        return convertToDto(updatedFavorite);
    }

    public boolean deleteFavorite(Integer id) {
        if (!favoriteRepository.existsById(id)) {
            return false;
        }
        favoriteRepository.deleteById(id);
        return true;
    }

    private FavoriteDto convertToDto(Favorite favorite) {
        FavoriteDto favoriteDto = new FavoriteDto();
        favoriteDto.setId(favorite.getId());
        favoriteDto.setUserId(favorite.getUserId());
        favoriteDto.setProductId(favorite.getProductId());
        favoriteDto.setTimestamp(favorite.getTimestamp());
        return favoriteDto;
    }

    private Favorite convertToEntity(FavoriteDto favoriteDto) {
        Favorite favorite = new Favorite();
        favorite.setId(favoriteDto.getId());
        favorite.setUserId(favoriteDto.getUserId());
        favorite.setProductId(favoriteDto.getProductId());
        favorite.setTimestamp(favoriteDto.getTimestamp());
        return favorite;
    }
}
