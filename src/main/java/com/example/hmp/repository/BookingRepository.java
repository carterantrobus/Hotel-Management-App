package com.example.hmp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hmp.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
  List<Booking> findByCustomerId(Long customerId);
  List<Booking> findByRoomId(Long roomId);
  List<Booking> findByDate(LocalDate startDate, LocalDate endDate);
}
