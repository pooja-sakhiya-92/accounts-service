package com.home.accountsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
public class AccountsServiceApplication {

	public static void main(String[] args) {

		System.setProperty("spring.config.name", "accounts-service");
		SpringApplication.run(AccountsServiceApplication.class, args);
	}

}
