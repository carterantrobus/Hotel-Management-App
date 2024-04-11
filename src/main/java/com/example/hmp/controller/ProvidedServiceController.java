package com.example.hmp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hmp.model.ProvidedService;
import com.example.hmp.service.ProvidedServiceService;

@Controller
public class ProvidedServiceController {

    private final ProvidedServiceService providedServiceService;

    @Autowired
    public ProvidedServiceController(ProvidedServiceService providedServiceService) {
        this.providedServiceService = providedServiceService;
    }

    @GetMapping("/services")
    public String showServicesPage(Model model) {
        model.addAttribute("providedService", new ProvidedService()); // Add an empty provided service object
        return "services"; // This corresponds to services.html in templates directory
    }
}
