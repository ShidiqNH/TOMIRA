package com.store.convenienceStore.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relasi ManyToOne dengan Products
    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private Products product;
    private String username;
    private int quantity;
    private String totalPrice;
    private String email;
	private String alamat; 
    private String kota;
    private int kode_pos;


    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setTransactionDate(LocalDate now) {
		// TODO Auto-generated method stub
		
	}
	public void setTotalAmount(double totalAmount) {
		// TODO Auto-generated method stub
		
	}
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getKota() {
		return kota;
	}
	public void setKota(String kota) {
		this.kota = kota;
	}
	public int getKode_pos() {
		return kode_pos;
	}
	public void setKode_pos(int kode_pos) {
		this.kode_pos = kode_pos;
	}
}

