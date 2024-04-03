package com.example.hmp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "BOOKING")
public class Booking {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "customer_id", nullable = false)
  private Customer customerId;

  @ManyToOne
  @JoinColumn(name = "room_id", nullable = false)
  private Room roomId;

  @Column(name = "start_date", nullable = false)
  private LocalDate startDate;

  @Column(name = "end_date", nullable = false)
  private LocalDate endDate;

  @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
  private Set<ProvidedService> services;

  // Constructors, getters, and setter
  public Booking() {}

  public Booking(Customer customerId, Room roomId, LocalDate startDate, LocalDate endDate) {
    this.customerId = customerId;
    this.roomId = roomId;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Customer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Customer customerId) {
    this.customerId = customerId;
  }

  public Room getRoomId() {
    return roomId;
  }

  public void setRoomId(Room roomId) {
    this.roomId = roomId;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public Set<ProvidedService> getServices() {
    return services;
  }

  public void setServices(Set<ProvidedService> services) {
    this.services = services;
  }

  public String toString() {
    return "Booking{id=" + id + ", customerId='" + customerId + "'', roomId='" + roomId + "'', startDate='" + startDate + "'', endDate='" + endDate + "'}";
  }
}
