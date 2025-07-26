package com.example.hmp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.hmp.model.Customer;
import com.example.hmp.model.Room;
import com.example.hmp.model.ProvidedService;
import com.example.hmp.service.CustomerService;
import com.example.hmp.service.RoomService;
import com.example.hmp.service.ProvidedServiceService;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private RoomService roomService;
    
    @Autowired
    private ProvidedServiceService serviceService;

    @Override
    public void run(String... args) throws Exception {
        // Only initialize if no data exists
        if (customerService.findAll().isEmpty()) {
            initializeSampleData();
        }
    }

    private void initializeSampleData() {
        // Create sample customers
        Customer customer1 = new Customer("John Smith", "555-0101", "john.smith@email.com");
        Customer customer2 = new Customer("Jane Doe", "555-0102", "jane.doe@email.com");
        Customer customer3 = new Customer("Bob Johnson", "555-0103", "bob.johnson@email.com");
        Customer customer4 = new Customer("Alice Brown", "555-0104", "alice.brown@email.com");
        
        customerService.save(customer1);
        customerService.save(customer2);
        customerService.save(customer3);
        customerService.save(customer4);

        // Create sample rooms
        Room room1 = new Room(101, "Standard", 99.99);
        Room room2 = new Room(102, "Standard", 99.99);
        Room room3 = new Room(201, "Deluxe", 149.99);
        Room room4 = new Room(202, "Deluxe", 149.99);
        Room room5 = new Room(301, "Suite", 299.99);
        Room room6 = new Room(302, "Suite", 299.99);
        
        roomService.save(room1);
        roomService.save(room2);
        roomService.save(room3);
        roomService.save(room4);
        roomService.save(room5);
        roomService.save(room6);

        // Create sample services
        ProvidedService service1 = new ProvidedService("Room Cleaning", "Daily room cleaning service", 25.00);
        ProvidedService service2 = new ProvidedService("Laundry Service", "Professional laundry and dry cleaning", 15.00);
        ProvidedService service3 = new ProvidedService("Room Service", "24/7 in-room dining service", 10.00);
        ProvidedService service4 = new ProvidedService("WiFi", "High-speed internet access", 5.00);
        ProvidedService service5 = new ProvidedService("Parking", "Secure parking space", 10.00);
        
        serviceService.save(service1);
        serviceService.save(service2);
        serviceService.save(service3);
        serviceService.save(service4);
        serviceService.save(service5);
    }
} 