package com.example.hmp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hmp.model.Customer;
import com.example.hmp.repository.CustomerRepository;

@Service
public class CustomerService {
	
    private CustomerRepository customerRepository;
    
	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    public Customer findByPhoneNumber(String phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber);
    }

    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
    
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
