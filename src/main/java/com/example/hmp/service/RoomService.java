package com.example.hmp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hmp.model.Room;
import com.example.hmp.repository.RoomRepository;

@Service
public class RoomService {

    private RoomRepository roomRepository;
    
	@Autowired
	public RoomService(RoomRepository roomRepository) {
		super();
		this.roomRepository = roomRepository;
	}

    public Room findByRoomNumber(int roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }

    public List<Room> findByType(String type) {
        return roomRepository.findByType(type);
    }

    public List<Room> findByPrice(Double price) {
        return roomRepository.findByPrice(price);
    }

    public Room save(Room room) {
        return roomRepository.save(room);
    }

    public void delete(Room room) {
        roomRepository.delete(room);
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }
    
    public Room findById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }
}
