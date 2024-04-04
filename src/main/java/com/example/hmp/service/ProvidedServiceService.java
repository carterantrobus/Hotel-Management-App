package com.example.hmp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hmp.model.ProvidedService;
import com.example.hmp.repository.ServiceRepository;

@Service
public class ProvidedServiceService {
	
    private ServiceRepository serviceRepository;
	@Autowired
	public ProvidedServiceService(ServiceRepository serviceRepository) {
		super();
		this.serviceRepository = serviceRepository;
	}
    public List<ProvidedService> findByName(String name) {
        return serviceRepository.findByName(name);
    }

    public List<ProvidedService> findByDescription(String description) {
        return serviceRepository.findByDescription(description);
    }

    public List<ProvidedService> findByPrice(Double price) {
        return serviceRepository.findByPrice(price);
    }

    public ProvidedService save(ProvidedService service) {
        return serviceRepository.save(service);
    }

    public void delete(ProvidedService service) {
        serviceRepository.delete(service);
    }

    public List<ProvidedService> findAll() {
        return serviceRepository.findAll();
    }
}
