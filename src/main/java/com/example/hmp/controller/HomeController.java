package com.example.hmp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hmp.service.BookingService;
import com.example.hmp.service.CustomerService;
import com.example.hmp.service.RoomService;
import com.example.hmp.service.ProvidedServiceService;

@Controller
public class HomeController {

    private final BookingService bookingService;
    private final CustomerService customerService;
    private final RoomService roomService;
    private final ProvidedServiceService serviceService;

    @Autowired
    public HomeController(BookingService bookingService, CustomerService customerService, 
                         RoomService roomService, ProvidedServiceService serviceService) {
        this.bookingService = bookingService;
        this.customerService = customerService;
        this.roomService = roomService;
        this.serviceService = serviceService;
    }

    @GetMapping("/")
    public String home(Model model) {
        // Add summary statistics to the model
        model.addAttribute("totalCustomers", customerService.findAll().size());
        model.addAttribute("totalRooms", roomService.findAll().size());
        model.addAttribute("totalBookings", bookingService.findAll().size());
        model.addAttribute("totalServices", serviceService.findAll().size());
        
        return "index";
    }
} 