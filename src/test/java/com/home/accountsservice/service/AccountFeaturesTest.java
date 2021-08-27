package com.home.accountsservice.service;

import com.home.accountsservice.exception.AccountException;
import com.home.accountsservice.model.Account;
import com.home.accountsservice.repository.AccountRepository;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class AccountFeaturesTest {

    @Injectable
    private AccountRepository repository;

   /* @Tested
    private Bar bar;
*/
    @Test
    public void testExample(@Mocked AccountService accountService) throws AccountException {
        new Expectations () {{
            accountService.getByAccountNumber ( String.valueOf ( 1L ));
            result = AccountServiceTest.createDummyAccount ();

        }};
        accountService.addBalance ( 1L,52000L);
    }
}
