package com.accounting.repository;

import com.accounting.booknote.exception.InsufficientBalanceException;
import com.accounting.booknote.repository.AccountRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for the account repository
 */
public class AccountRepositoryTest {

    @Test
    public void shouldReturnBalanceWhenValidTransactions() {
        AccountRepository repository = new AccountRepository();
        repository.creditAccount(10.0);
        repository.debitAccount(4.0);
        assertEquals(6.0, repository.getAccountBalance());
    }

    @Test
    public void shouldThrowExceptionWhenInsufficientBalance() {
        AccountRepository repository = new AccountRepository();
        repository.creditAccount(10.0);
        assertThrows(InsufficientBalanceException.class, () -> repository.debitAccount(40.0));
    }
}
