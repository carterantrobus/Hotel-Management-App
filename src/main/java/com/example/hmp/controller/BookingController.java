package com.example.hmp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hmp.model.Booking;
import com.example.hmp.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/customer/{customerId}")
    public List<Booking> getBookingsByCustomerId(@PathVariable Long customerId) {
        return bookingService.findByCustomerId(customerId);
    }

    @GetMapping("/room/{roomId}")
    public List<Booking> getBookingsByRoomId(@PathVariable Long roomId) {
        return bookingService.findByRoomId(roomId);
    }

    @GetMapping("/date")
    public List<Booking> getBookingsByDateRange(@RequestParam("startDate") LocalDate startDate,
                                                @RequestParam("endDate") LocalDate endDate) {
        return bookingService.findByDate(startDate, endDate);
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.save(booking);
    }


    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.findAll();
    }
}
