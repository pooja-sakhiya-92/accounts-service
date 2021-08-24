package com.home.accountsservice.repository;

import com.home.accountsservice.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;

public interface AccountRepository extends CrudRepository<Account, BigDecimal> {
}
