package com.example.hmp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.hmp.model.Booking;
import com.example.hmp.model.Customer;
import com.example.hmp.model.Room;
import com.example.hmp.service.BookingService;
import com.example.hmp.service.CustomerService;
import com.example.hmp.service.RoomService;

@Controller
public class BookingController {

    private final BookingService bookingService;
    private final CustomerService customerService;
    private final RoomService roomService;

    @Autowired
    public BookingController(BookingService bookingService, CustomerService customerService, RoomService roomService) {
        this.bookingService = bookingService;
        this.customerService = customerService;
        this.roomService = roomService;
    }

    /* Show bookings page with all bookings */
    @GetMapping("/bookings")
    public String showBookingsPage(Model model) {
        List<Booking> bookings = bookingService.findAll(); 
        List<Customer> customers = customerService.findAll();
        List<Room> rooms = roomService.findAll();
        
        model.addAttribute("bookings", bookings);
        model.addAttribute("customers", customers);
        model.addAttribute("rooms", rooms);
        model.addAttribute("booking", new Booking());
        return "bookings"; 
    }
    
    /* Saving bookings */
    @PostMapping("/bookings")
    public String saveBooking(@ModelAttribute("Booking") Booking booking, RedirectAttributes redirectAttributes) {
        // Validation
        if (booking.getCustomerId() == null || booking.getRoomId() == null) {
            redirectAttributes.addFlashAttribute("error", "Customer and Room are required.");
            return "redirect:/bookings";
        }
        
        if (booking.getStartDate() == null || booking.getEndDate() == null) {
            redirectAttributes.addFlashAttribute("error", "Start date and end date are required.");
            return "redirect:/bookings";
        }
        
        // Check if end date is after start date
        if (booking.getEndDate().isBefore(booking.getStartDate()) || booking.getEndDate().isEqual(booking.getStartDate())) {
            redirectAttributes.addFlashAttribute("error", "End date must be after start date.");
            return "redirect:/bookings";
        }
        
        // Check if start date is not in the past
        if (booking.getStartDate().isBefore(LocalDate.now())) {
            redirectAttributes.addFlashAttribute("error", "Start date cannot be in the past.");
            return "redirect:/bookings";
        }
        
        // Validate that customer and room exist
        Customer customer = customerService.findById(booking.getCustomerId().getId());
        Room room = roomService.findById(booking.getRoomId().getId());
        
        if (customer == null) {
            redirectAttributes.addFlashAttribute("error", "Selected customer does not exist.");
            return "redirect:/bookings";
        }
        
        if (room == null) {
            redirectAttributes.addFlashAttribute("error", "Selected room does not exist.");
            return "redirect:/bookings";
        }
        
        try {
            bookingService.save(booking);
            redirectAttributes.addFlashAttribute("success", "Booking created successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to create booking. Please try again.");
        }
        
        return "redirect:/bookings";
    }
}