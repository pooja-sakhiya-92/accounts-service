package com.home.accountsservice.repository;

import com.home.accountsservice.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith (SpringRunner.class)
@SpringBootTest
//@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void initUseCase ( ) {
        List<Customer> customers = Arrays.asList (
                new Customer ( 1, "Pooja", "Sakhiya" ),
                new Customer ( 2, "Pooja", "Thesia" ),
                new Customer ( 3, "Snehal", "Thesia" )
        );
        customerRepository.saveAll ( customers );
    }

    @AfterEach
    public void destroyAll ( ) {
        customerRepository.deleteAll ( );
    }

    @Test
    void saveAll_success ( ) {
        List<Customer> allCustomer = (List<Customer>) customerRepository.findAll ( );

        AtomicInteger validIdFound = new AtomicInteger ( );
        allCustomer.forEach ( customer -> {
            if (customer.getCustomerNumber ( ) > 0) {
                validIdFound.getAndIncrement ( );
            }
        } );

        assert (validIdFound.intValue ( ) == 3);
    }

    @Test
    void findAll_success ( ) {
        List<Customer> allCustomer = (List<Customer>) customerRepository.findAll ( );
        assert (allCustomer.size ( ) > 1);
    }

}
