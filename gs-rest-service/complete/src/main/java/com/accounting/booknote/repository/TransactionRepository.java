package com.accounting.booknote.repository;

import com.accounting.booknote.exception.TransactionNotFoundException;
import com.accounting.booknote.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Repository to handle all the transaction database operations
 */
@Repository
public class TransactionRepository {

    private static Map<String, Transaction> transactions = new HashMap<>();

    public List<Transaction> findAll() {
        return transactions.values().stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public Transaction findById(String id) {
        Transaction transaction = transactions.get(id);
        if (transaction == null) {
            throw new TransactionNotFoundException("No transaction was found for id: " + id);
        }
        return transaction;
    }

    public void save(Transaction transaction) {
        transactions.put(transaction.getId(), transaction);
    }
}
