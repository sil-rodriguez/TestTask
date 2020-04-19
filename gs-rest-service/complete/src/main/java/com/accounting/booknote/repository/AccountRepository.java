package com.accounting.booknote.repository;

import com.accounting.booknote.exception.InsufficientBalanceException;
import org.springframework.stereotype.Repository;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Repository to handle all the account database operations
 */
@Repository
public class AccountRepository {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private double accountBalance;

    public void creditAccount(double credit) {
        lock.writeLock().lock();
        try {
            accountBalance = accountBalance + credit;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void debitAccount(double debit) {
        lock.writeLock().lock();
        try {
            if (accountBalance > debit) {
                accountBalance = accountBalance - debit;
            } else {
                throw new InsufficientBalanceException("Account balance is insufficient");
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public double getAccountBalance() {
        lock.readLock().lock();
        try {
            return accountBalance;
        } finally {
            lock.readLock().unlock();
        }
    }
}
