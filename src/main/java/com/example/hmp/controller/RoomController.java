package com.example.hmp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hmp.model.Room;
import com.example.hmp.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/{roomNumber}")
    public Room getRoomByRoomNumber(@PathVariable int roomNumber) {
        return roomService.findByRoomNumber(roomNumber);
    }

    @GetMapping("/type/{type}")
    public List<Room> getRoomsByType(@PathVariable String type) {
        return roomService.findByType(type);
    }

    @GetMapping("/price/{price}")
    public List<Room> getRoomsByPrice(@PathVariable Double price) {
        return roomService.findByPrice(price);
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomService.save(room);
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.findAll();
    }
}
