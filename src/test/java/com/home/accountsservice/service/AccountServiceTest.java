package com.home.accountsservice.service;

import com.home.accountsservice.exception.AccountException;
import com.home.accountsservice.model.Account;
import com.home.accountsservice.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AccountServiceTest {

    @InjectMocks
    AccountService accountService;

    @Mock
    AccountRepository accountRepository;


    @BeforeEach
    public void setUp(){
        when(accountRepository.save ( Mockito.any () )).thenReturn ( createDummyAccount() );
        when(accountRepository.findById ( Mockito.any () )).thenReturn ( Optional.of ( createDummyAccount() ));
    }

    @DisplayName("Test create/update account")
    @Test
    public void testCreateAccount() throws AccountException {
        Account account = accountService.saveOrUpdate ( createDummyAccount ( ) );
        assertEquals(1L, account.getAccountNumber ());
    }

    @DisplayName("Test Get account")
    @Test
    public void testGetAccount() throws AccountException {
        Account account = accountService.getByAccountNumber ( String.valueOf ( 1L) );
        assertEquals(1L, account.getAccountNumber ());
        assertEquals ( BigDecimal.valueOf ( 52000), account.getBalance () );
    }

    private Account createDummyAccount ( ) {
        Account testAccount = new Account ();
        testAccount.setBalance ( BigDecimal.valueOf ( 52000 ));
        testAccount.setAccountNumber ( 1L);
        return testAccount;
    }

}
