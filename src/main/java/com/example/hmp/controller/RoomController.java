package com.example.hmp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hmp.model.Room;
import com.example.hmp.service.RoomService;

import java.util.List;

@Controller
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public String showRoomsPage(Model model) {
        model.addAttribute("room", new Room()); // Add an empty room object
        return "rooms"; // This corresponds to rooms.html in templates directory
    }
}
