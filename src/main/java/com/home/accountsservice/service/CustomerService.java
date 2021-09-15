package com.home.accountsservice.service;

import com.home.accountsservice.model.Customer;
import com.home.accountsservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer getCustomerById(Long id) {
		return Optional.of(customerRepository.findByCustomerNumber(id.intValue())).get().orElse(null);
	}

	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}

	public List<Customer> getAllCustomers() {
		List<Customer> allCustomers = new ArrayList<>();
		customerRepository.findAll().forEach(customer -> {
			allCustomers.add(customer);
		});
		return allCustomers;
	}

	public String addCustomer() {
		customerRepository.save(new Customer(1, "Jack", "Bauer"));
		customerRepository.save(new Customer(2, "Chloe", "O'Brian"));
		customerRepository.save(new Customer(3, "Kim", "Bauer"));
		customerRepository.save(new Customer(4, "David", "Palmer"));
		customerRepository.save(new Customer(5, "Michelle", "Dessler"));

		return "Customers added successfully";
	}

	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}
