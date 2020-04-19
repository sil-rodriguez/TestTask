package com.accounting.booknote.service;

import com.accounting.booknote.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service to handle the transaction operations
 */
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public void creditAccount(double amount){
        accountRepository.creditAccount(amount);
    }

    public void debitAccount(double amount){
        accountRepository.debitAccount(amount);
    }

    public double getAccountBalance(){
        return accountRepository.getAccountBalance();
    }

    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
