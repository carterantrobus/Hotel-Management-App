package com.example.hmp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hmp.model.Customer;
import com.example.hmp.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/name/{name}")
    public List<Customer> getCustomersByName(@PathVariable String name) {
        return customerService.findByName(name);
    }

    @GetMapping("/phoneNumber/{phoneNumber}")
    public Customer getCustomerByPhoneNumber(@PathVariable String phoneNumber) {
        return customerService.findByPhoneNumber(phoneNumber);
    }

    @GetMapping("/email/{email}")
    public Customer getCustomerByEmail(@PathVariable String email) {
        return customerService.findByEmail(email);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }
}
