package com.store.convenienceStore.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.convenienceStore.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}