package com.example.nxtstayz.repository;

import java.util.ArrayList;

import com.example.nxtstayz.model.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    ArrayList<Hotel> findByLocation(String location);
}
