package com.home.accountsservice.service;

import com.home.accountsservice.exception.AccountException;
import com.home.accountsservice.model.Account;
import com.home.accountsservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getByAccountNumber (String accountNumber) throws AccountException {
        System.out.println ( "This is account service" );
        return Optional.ofNullable ( accountRepository.findById ( BigDecimal.valueOf ( 1.00 ) )).get().orElse (  null);
    }

    public Account saveOrUpdate (Account account) throws AccountException {

        //Pre conditions check
        checkElligibility ( account );
        return accountRepository.save ( account );
    }

    private boolean checkElligibility (Account account) throws AccountException {
        if (2000 > account.getBalance ( ).intValue ( ))
            throw new AccountException ( "Please provide balance greater than 2000" );
        return true;
    }

    public Account addBalance(Long accountNumber,Long creditAmount) throws AccountException {
        Account toCreditAccount = getByAccountNumber ( String.valueOf ( accountNumber ) );
        toCreditAccount.setBalance ( BigDecimal.valueOf ( toCreditAccount.getBalance ().longValue () + creditAmount ));
        return accountRepository.save ( toCreditAccount );
    }

    //TODO
    /*Add methods for
     * Credit
     * debit
     * view transactions
     * show account details
     *
     * */
}
