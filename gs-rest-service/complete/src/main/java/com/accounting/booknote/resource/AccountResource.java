package com.accounting.booknote.resource;

import com.accounting.booknote.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Resource to handle the account requests
 */
@RestController
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @GetMapping("/")
     public double getAccountBalance(){
        return accountService.getAccountBalance();
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}