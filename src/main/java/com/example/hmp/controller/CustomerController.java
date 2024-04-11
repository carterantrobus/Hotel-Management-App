package com.example.hmp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hmp.model.Customer;
import com.example.hmp.service.CustomerService;

import java.util.List;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String showCustomersPage(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("customer", new Customer()); // Add an empty customer object
        return "customers"; // This corresponds to customers.html in templates directory
    }

}
