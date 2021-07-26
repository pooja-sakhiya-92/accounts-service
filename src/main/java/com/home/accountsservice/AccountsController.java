package com.home.accountsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    @Autowired
    AccountService accountService;

    @Value( "${test.param1}" )
    private String param1;


    @Value( "${test.param2}" )
    private String param2;

    @GetMapping("/accounts/{accountNumber}")
    public Account getAccountDetails(@PathVariable String accountNumber) throws AccountNotFoundException {
        System.out.println(param1 + " " + param2);
        return accountService.getByNumber("123");
    }
}
