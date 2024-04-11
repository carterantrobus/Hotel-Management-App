package com.example.hmp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hmp.model.Booking;
import com.example.hmp.model.Customer;
import com.example.hmp.model.Room;

public interface BookingRepository extends JpaRepository<Booking, Long> {
  List<Booking> findByCustomerId(Customer customerId);
  List<Booking> findByRoomId(Room roomId);
  List<Booking> findByStartDateBetween(LocalDate startDate, LocalDate endDate);
}
