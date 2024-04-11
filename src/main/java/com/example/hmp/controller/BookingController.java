package com.example.hmp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hmp.model.Booking;
import com.example.hmp.model.Room;
import com.example.hmp.service.BookingService;

@Controller
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    /* Show bookings page with all bookings */
    @GetMapping("/bookings")
    public String showBookingsPage(Model model) {
        List<Booking> bookings = bookingService.findAll(); 
        model.addAttribute("bookings", bookings);
        model.addAttribute("booking", new Booking());
        return "bookings"; 
    }
    
    /* Saving bookings */
    @PostMapping("/bookings")
    public String saveBooking(@ModelAttribute("Booking") Booking booking) {
        bookingService.save(booking);        
        return "redirect:/bookings";
    }
}