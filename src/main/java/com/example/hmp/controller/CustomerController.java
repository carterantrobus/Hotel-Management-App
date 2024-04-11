package com.example.hmp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hmp.model.Customer;
import com.example.hmp.model.Room;
import com.example.hmp.service.CustomerService;

import java.util.List;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
  
    /* Show customers page with all customers */
    @GetMapping("/customers")
    public String showCustomersPage(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("customer", new Customer()); 
        return "customers"; 
    }
    
    /* Saving customers */
    @PostMapping("/customers")
    public String saveCustomer(@ModelAttribute("Customer") Customer customer) {
        // Logic to save the room to the database
        customerService.save(customer);        
        // Redirect to prevent duplicate form submissions
        return "redirect:/customers";
    }
    

}
