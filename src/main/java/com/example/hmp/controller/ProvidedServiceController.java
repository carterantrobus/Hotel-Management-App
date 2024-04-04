package com.example.hmp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hmp.model.ProvidedService;
import com.example.hmp.service.ProvidedServiceService;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ProvidedServiceController {

    private final ProvidedServiceService providedServiceService;

    @Autowired
    public ProvidedServiceController(ProvidedServiceService providedServiceService) {
        this.providedServiceService = providedServiceService;
    }

    @GetMapping("/name/{name}")
    public List<ProvidedService> getServicesByName(@PathVariable String name) {
        return providedServiceService.findByName(name);
    }

    @GetMapping("/description/{description}")
    public List<ProvidedService> getServicesByDescription(@PathVariable String description) {
        return providedServiceService.findByDescription(description);
    }

    @GetMapping("/price/{price}")
    public List<ProvidedService> getServicesByPrice(@PathVariable Double price) {
        return providedServiceService.findByPrice(price);
    }

    @PostMapping
    public ProvidedService createService(@RequestBody ProvidedService service) {
        return providedServiceService.save(service);
    }

    @DeleteMapping("/name/{serviceName}")
    public void deleteService(@PathVariable String serviceName) {
        List<ProvidedService> services = providedServiceService.findByName(serviceName);
        if (!services.isEmpty()) {
            providedServiceService.delete(services.get(0));
        } else {

        }
    }


    @GetMapping
    public List<ProvidedService> getAllServices() {
        return providedServiceService.findAll();
    }
}
