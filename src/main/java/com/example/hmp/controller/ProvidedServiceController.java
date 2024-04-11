package com.example.hmp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hmp.model.Booking;
import com.example.hmp.model.ProvidedService;
import com.example.hmp.service.ProvidedServiceService;

@Controller
public class ProvidedServiceController {

    private final ProvidedServiceService providedServiceService;

    @Autowired
    public ProvidedServiceController(ProvidedServiceService providedServiceService) {
        this.providedServiceService = providedServiceService;
    }
    
    /* Show services page with all services */
    @GetMapping("/services")
    public String showServicesPage(Model model) {
        List<ProvidedService> services = providedServiceService.findAll(); 
        model.addAttribute("services", services); 
        model.addAttribute("providedService", new ProvidedService()); 
        return "services"; 
    }
    
    /* Saving services */
    @PostMapping("/services")
    public String saveService(@ModelAttribute("providedService") ProvidedService providedService) {
        providedServiceService.save(providedService);
        return "redirect:/services";
    }
}