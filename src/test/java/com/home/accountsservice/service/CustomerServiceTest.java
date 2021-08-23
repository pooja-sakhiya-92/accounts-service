package com.home.accountsservice.service;

import com.home.accountsservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    private Customer pooja = new Customer ( 4, "pooja", "sakhiya-" );

    @BeforeEach
    public void createCustomer ( ) {
        customerService.createCustomer ( pooja );
    }

    @Test
    public void getCustomer ( ) {
        Customer customer = customerService.getCustomerById ( 4L );
        System.out.println ( customer );
        assert customer != null;
    }
}
