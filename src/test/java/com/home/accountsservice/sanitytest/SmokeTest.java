package com.home.accountsservice.sanitytest;

import com.home.accountsservice.controller.AccountsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = {"test.param1=Test", "test.param2=Test"})
public class SmokeTest {

    @Autowired
    private AccountsController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}