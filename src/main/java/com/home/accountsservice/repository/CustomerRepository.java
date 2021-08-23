package com.home.accountsservice.repository;

import com.home.accountsservice.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByContactLastName(String lastName);

    List<Customer> findByContactFirstName(String lastName);

    Optional<Customer> findByCustomerNumber(int id);
}
