package com.store.convenienceStore.models;

import java.util.Date;

public class FavoriteDto {

    private Integer id; // Keep data type as Integer if it matches the database
    private Integer userId;
    private Integer productId;
    private Date timestamp;

    // Constructors
    public FavoriteDto() {
    }

    public FavoriteDto(Integer id, Integer userId, Integer productId, Date timestamp) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.timestamp = timestamp;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
