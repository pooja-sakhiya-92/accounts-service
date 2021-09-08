package com.home.accountsservice.service;

import com.home.accountsservice.exception.AccountException;
import com.home.accountsservice.model.Account;
import com.home.accountsservice.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountFeaturesTest {

    @InjectMocks
    AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    /*Positive scenario
    * 1. Account number is same as passed value
    * */
    @Test
    public void testGetAccountNumberExists ( ) throws AccountException {
        when(accountRepository.findById ( Mockito.any () )).thenReturn
                ( Optional.of ( AccountServiceTest.createDummyAccount(25000L,1L) )).thenReturn (
                Optional.of ( AccountServiceTest.createDummyAccount(52000L,2L) )
        );
        Account resultAccont = accountService.getByAccountNumber ( "1" );
        Account resultAccont2 = accountService.getByAccountNumber ( "2" );
        assertEquals ( 1L,  resultAccont.getAccountNumber ( ) );
        assertEquals ( 2L,  resultAccont2.getAccountNumber ( ) );
    }

    @Test
    public void testGetAccountNumberExistsSingleCall ( ) throws AccountException {
        when(accountRepository.findById ( Mockito.any () )).thenReturn
                ( Optional.of ( AccountServiceTest.createDummyAccount(25000L,1L) )
        );
        Account resultAccont = accountService.getByAccountNumber ( "1" );
        assertEquals ( 1L,  resultAccont.getAccountNumber ( ) );
        assertEquals ( BigDecimal.valueOf ( 25000L),resultAccont.getBalance () );
    }

    /*Negative scenario
     * 1. Account number is not same as passed value
     * */
    @Test
    public void testGetByAccountNumberNotExist ( ) throws AccountException {
        Account resultAccount = accountService.getByAccountNumber ( "56" );
        assert resultAccount == null;
    }

    @Test(expected = AccountException.class)
    public void testGetByAccountNumberNotExistWithException ( ) throws AccountException {
        accountService.getAccountNumber (BigDecimal.valueOf ( 56L ));
    }



}
