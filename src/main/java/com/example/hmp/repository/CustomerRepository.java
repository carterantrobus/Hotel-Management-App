package com.example.hmp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hmp.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
  List<Customer> findByName(String name);
  Customer findByPhoneNumber(String phoneNumber);
  Customer findByEmail(String email);
}
