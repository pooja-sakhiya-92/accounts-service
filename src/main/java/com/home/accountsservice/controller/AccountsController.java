package com.home.accountsservice.controller;

import com.home.accountsservice.exception.AccountException;
import com.home.accountsservice.model.Account;
import com.home.accountsservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountsController {

    @Autowired
    AccountService accountService;

    @GetMapping("/accounts/{accountNumber}")
    public Account getAccountDetails(@PathVariable String accountNumber) throws AccountException {
        return accountService.getByAccountNumber ("1000");
    }

    @PostMapping("/accounts/create")
    public  ResponseEntity<Account> createAccount(@RequestBody Account account) throws AccountException {
        return new ResponseEntity<Account> (accountService.saveOrUpdate ( account ), HttpStatus.OK);
    }

    @PostMapping("/accounts/credit")
    public  ResponseEntity<Account> creditAccount(@RequestParam String accountNumber,@RequestParam Long creditAmount) throws AccountException {
        return new ResponseEntity<Account> (accountService.addBalance ( Long.valueOf ( accountNumber ),creditAmount ), HttpStatus.OK);
    }

}
