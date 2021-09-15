package com.home.accountsservice.repository;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.home.accountsservice.model.Account;

public interface AccountRepository extends CrudRepository<Account, BigDecimal> {
}
