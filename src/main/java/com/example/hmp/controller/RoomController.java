package com.example.hmp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hmp.model.ProvidedService;
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
    
    /* Show rooms page with all rooms */
    @GetMapping("/rooms")
    public String showRoomsPage(Model model) {
        List<Room> rooms = roomService.findAll(); 
        model.addAttribute("rooms", rooms); 
        model.addAttribute("room", new Room()); 
        return "rooms"; 
    }

    /* Saving rooms */
    @PostMapping("/rooms")
    public String saveRoom(@ModelAttribute("Room") Room room) {
        roomService.save(room);        
        return "redirect:/rooms";
    }
}

