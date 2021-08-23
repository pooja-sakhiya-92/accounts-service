package com.home.accountsservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
//@EnableDiscoveryClient
@SpringBootApplication
public class AccountsServiceApplication {

    private static final Logger log = LoggerFactory.getLogger(AccountsServiceApplication.class);

    public static void main(String[] args) {

        System.setProperty("spring.config.name", "account-server");
        SpringApplication.run(AccountsServiceApplication.class, args);
    }

}
