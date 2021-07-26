package com.home.accountsservice;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public Account getByNumber(String accountNumber) throws AccountNotFoundException {
       System.out.println("This is account service");
        Account account = new Account();
        account.setBalance(200000);
        return account;
    }
}
