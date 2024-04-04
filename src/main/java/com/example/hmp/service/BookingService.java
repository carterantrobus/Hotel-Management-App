package com.example.hmp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hmp.model.Booking;
import com.example.hmp.repository.BookingRepository;
@Service
public class BookingService {

    private BookingRepository bookingRepository;
    @Autowired
	public BookingService(BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}

    public List<Booking> findByCustomerId(Long customerId) {
        return bookingRepository.findByCustomerId(customerId);
    }

    public List<Booking> findByRoomId(Long roomId) {
        return bookingRepository.findByRoomId(roomId);
    }

    public List<Booking> findByDate(LocalDate startDate, LocalDate endDate) {
        return bookingRepository.findByDate(startDate, endDate);
    }

    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void delete(Booking booking) {
        bookingRepository.delete(booking);
    }

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }
}
