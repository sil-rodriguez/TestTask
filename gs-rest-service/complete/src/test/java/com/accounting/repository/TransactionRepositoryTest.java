package com.accounting.repository;

import com.accounting.booknote.exception.TransactionNotFoundException;
import com.accounting.booknote.model.Transaction;
import com.accounting.booknote.repository.TransactionRepository;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the transaction repository
 */
public class TransactionRepositoryTest {

    @Test
    public void shouldReturnTransactionListWhenValidTransaction() {
        TransactionRepository repository = new TransactionRepository();
        Transaction credit = new Transaction();
        credit.setId(UUID.randomUUID().toString());
        credit.setTimestamp(new Date());
        credit.setType("credit");
        Transaction debit = new Transaction();
        debit.setId(UUID.randomUUID().toString());
        debit.setTimestamp(new Date());
        debit.setType("debit");
        repository.save(credit);
        repository.save(debit);
        List<Transaction> transactions = repository.findAll();
        assertFalse(transactions.isEmpty());
    }

    @Test
    public void shouldReturnTransactionWhenValidTransactionID() {
        TransactionRepository repository = new TransactionRepository();
        Transaction credit = new Transaction();
        String ID = UUID.randomUUID().toString();
        credit.setId(ID);
        credit.setTimestamp(new Date());
        repository.save(credit);
        Transaction transaction = repository.findById(ID);
        assertNotNull(transaction);
    }

    @Test
    public void shouldFailWhenTransactionIDDoesNotExist() {
        TransactionRepository repository = new TransactionRepository();
        Transaction credit = new Transaction();
        String ID = UUID.randomUUID().toString();
        credit.setId(ID);
        credit.setTimestamp(new Date());
        assertThrows(TransactionNotFoundException.class, () -> repository.findById(ID));
    }
}
