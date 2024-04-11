package com.example.hmp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hmp.model.Booking;
import com.example.hmp.service.BookingService;

@Controller
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Add a method to handle the /bookings endpoint
    @GetMapping("/bookings")
    public String showBookingsPage(Model model) {
        model.addAttribute("booking", new Booking()); // Add a new Booking object to the model
        return "bookings"; // This corresponds to bookings.html in templates directory
    }
}
