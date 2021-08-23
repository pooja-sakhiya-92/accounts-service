package com.home.accountsservice.controller;

import com.home.accountsservice.exception.AccountNotFoundException;
import com.home.accountsservice.model.Account;
import com.home.accountsservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    @Autowired
    AccountService accountService;

    @GetMapping("/accounts/{accountNumber}")
    public Account getAccountDetails(@PathVariable String accountNumber) throws AccountNotFoundException {
        return accountService.getByNumber("123");
    }

}
