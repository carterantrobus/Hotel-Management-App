package com.example.hmp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String saveRoom(@ModelAttribute("Room") Room room, RedirectAttributes redirectAttributes) {
        // Validation
        if (room.getRoomNumber() <= 0) {
            redirectAttributes.addFlashAttribute("error", "Room number must be a positive number.");
            return "redirect:/rooms";
        }
        
        if (room.getType() == null || room.getType().trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Room type is required.");
            return "redirect:/rooms";
        }
        
        if (room.getPrice() == null || room.getPrice() <= 0) {
            redirectAttributes.addFlashAttribute("error", "Price must be a positive number.");
            return "redirect:/rooms";
        }
        
        // Check if room number already exists
        Room existingRoom = roomService.findByRoomNumber(room.getRoomNumber());
        if (existingRoom != null && !existingRoom.getId().equals(room.getId())) {
            redirectAttributes.addFlashAttribute("error", "Room number " + room.getRoomNumber() + " already exists.");
            return "redirect:/rooms";
        }
        
        try {
            roomService.save(room);
            redirectAttributes.addFlashAttribute("success", "Room saved successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to save room. Please try again.");
        }
        
        return "redirect:/rooms";
    }
}

