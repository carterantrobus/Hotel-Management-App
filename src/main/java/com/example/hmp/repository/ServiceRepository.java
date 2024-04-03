package com.example.hmp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hmp.model.ProvidedService;

public interface ServiceRepository extends JpaRepository<ProvidedService, Long> {
  List<ProvidedService> findByName(String name);
  List<ProvidedService> findByDescription(String description);
  List<ProvidedService> findByPrice(Double price);
}
