package com.example.nxtstayz.repository;

import java.util.ArrayList;

import com.example.nxtstayz.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    // Example of a custom query method following Spring Data JPA naming conventions
    ArrayList<Room> findByType(String roomType);

    // Example of a custom query method using @Query annotation
    @Query("SELECT r FROM Room r WHERE r.price <= :maxPrice")
    ArrayList<Room> findRoomsByPriceLessThanEqual(double maxPrice);

    // Additional custom query methods can be added here if needed
}
