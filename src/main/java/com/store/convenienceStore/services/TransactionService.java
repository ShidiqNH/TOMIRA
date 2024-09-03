package com.store.convenienceStore.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.store.convenienceStore.models.Transaction;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public boolean processTransaction(Long productId, int quantity, String username) {
        // Logic to process the transaction
        return true; // Replace with actual transaction processing logic
    }

    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
