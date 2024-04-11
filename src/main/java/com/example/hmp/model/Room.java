package com.example.hmp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import java.util.Set;

@Entity
@Table(name = "ROOM")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_number", nullable = false)
    private int roomNumber;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "price", nullable = false)
    private Double price;

    @OneToMany(mappedBy = "roomId")
    private Set<Booking> bookings;

    public Room() {}

    public Room(int roomNumber, String type, Double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
    }

    public Long getId() {
        return id; 
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "Room{id=" + id + ", roomNumber=" + roomNumber + ", type='" + type + "', price=" + price + "}";
    }
}
