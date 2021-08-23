package com.home.accountsservice.controller;

import com.home.accountsservice.model.Customer;
import com.home.accountsservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer/add")
    public String addCustomer ( ) {
        return customerService.addCustomer ( );
    }

    @PostMapping("/customer/create")
    public Customer createCustomer ( @RequestBody Customer customer) {
        return customerService.createCustomer (customer );
    }

    @GetMapping("/customer/all")
    public List<Customer> getAllCustomers ( ) {
        return customerService.getAllCustomers ( );
    }


    @DeleteMapping("/customer/remove/{id}")
    public void deleteCustomer (@PathVariable Long id) {
        customerService.deleteCustomer ( id );
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById (@PathVariable Long id) {
        return customerService.getCustomerById ( id );
    }

}
