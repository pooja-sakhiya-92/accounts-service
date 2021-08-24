package com.home.accountsservice.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private BigDecimal id;

    @Column
    private Long accountNumber;

    @Column
    private BigDecimal balance;

    @Column
    private String type;


    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getAccountNumber ( ) {
        return accountNumber;
    }

    public void setAccountNumber (Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getId ( ) {
        return id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
