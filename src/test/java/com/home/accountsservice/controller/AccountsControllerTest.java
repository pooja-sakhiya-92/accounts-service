package com.home.accountsservice.controller;

import com.home.accountsservice.service.AccountService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith (MockitoJUnitRunner.class)
public class AccountsControllerTest {

    @InjectMocks
    AccountsController accountsController;

    @Mock
    AccountService accountService;


}
