package com.example.hmp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hmp.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
  Room findByRoomNumber(int roomNumber);
  List<Room> findByType(String type);
  List<Room> findByPrice(Double price);
}
