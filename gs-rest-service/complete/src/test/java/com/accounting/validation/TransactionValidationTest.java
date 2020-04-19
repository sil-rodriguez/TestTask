package com.accounting.validation;

import com.accounting.booknote.model.Transaction;
import com.accounting.booknote.validation.TransactionValidation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for the transaction validation
 */
public class TransactionValidationTest {

    @Test
    public void shouldReturnEmptyWhenValidTransaction() {
        TransactionValidation validation = new TransactionValidation();
        Transaction transaction = new Transaction();
        transaction.setType("credit");
        transaction.setAmount(1.0);
        List<String> errors = validation.validate(transaction);
        assertTrue(errors.isEmpty());
    }

    @Test
    public void shouldFailWhenInvalidTransactionType() {
        TransactionValidation validation = new TransactionValidation();
        Transaction transaction = new Transaction();
        transaction.setType("invalid type");
        transaction.setAmount(1.0);
        List<String> errors = validation.validate(transaction);
        assertTrue(errors.contains("Transaction type must be 'credit' or 'debit'"));
    }

    @Test
    public void shouldFailWhenInvalidTransactionAmountIsZero() {
        TransactionValidation validation = new TransactionValidation();
        Transaction transaction = new Transaction();
        transaction.setType("debit");
        transaction.setAmount(0.0);
        List<String> errors = validation.validate(transaction);
        assertTrue(errors.contains("Transaction amount must be greater than 0"));
    }

    @Test
    public void shouldFailWhenInvalidTransactionAmountIsNegative() {
        TransactionValidation validation = new TransactionValidation();
        Transaction transaction = new Transaction();
        transaction.setType("credit");
        transaction.setAmount(-1.0);
        List<String> errors = validation.validate(transaction);
        assertTrue(errors.contains("Transaction amount must be greater than 0"));
    }
}
