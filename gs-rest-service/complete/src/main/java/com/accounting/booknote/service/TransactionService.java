package com.accounting.booknote.service;

import com.accounting.booknote.model.Transaction;
import com.accounting.booknote.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Service to handle the transaction operations
 */
@Service
public class TransactionService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> find() {
        return transactionRepository.findAll();
    }

    public Transaction findById(String id) {
        return transactionRepository.findById(id);
    }

    public Transaction commit(Transaction transaction) {
        if (transaction.isCreditTransaction()) {
            accountService.creditAccount(transaction.getAmount());
        } else {
            accountService.debitAccount(transaction.getAmount());
        }
        transaction.setId(UUID.randomUUID().toString());
        transaction.setTimestamp(new Date());
        transactionRepository.save(transaction);
        return transaction;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setTransactionRepository(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
}
