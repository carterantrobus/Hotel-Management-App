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
@Table(name = "CUSTOMER")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "phone_number", nullable = false)
  private String phoneNumber;

  @Column(name = "email", nullable = false)
  private String email;

  @OneToMany(mappedBy = "customerId")
  private Set<Booking> bookings;

  // Constructors, getters, and setter
  public Customer() {}

  public Customer(String name, String phoneNumber, String email) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Set<Booking> getBookings() {
    return bookings;
  }

  public void setBookings(Set<Booking> bookings) {
    this.bookings = bookings;
  }

  public String toString() {
    return "Customer{id:" + id + ", name='" + name + "'', phoneNumber='" + phoneNumber + "'', email='" + email + "'}";
  }
}
