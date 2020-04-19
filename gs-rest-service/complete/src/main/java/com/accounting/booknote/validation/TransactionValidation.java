package com.accounting.booknote.validation;

import com.accounting.booknote.model.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class to validate transaction format
 */
public class TransactionValidation implements Validator<Transaction> {

    List<String> validTransactionTypes = Arrays.asList("credit", "debit");

    @Override
    public List<String> validate(Transaction transaction) {
        List<String> errors = new ArrayList<>();
        if (transaction.getAmount() <= 0) {
            errors.add("Transaction amount must be greater than 0");
        }
        if (!validTransactionTypes.contains(transaction.getType())) {
            errors.add("Transaction type must be 'credit' or 'debit'");
        }
        return errors;
    }
}
