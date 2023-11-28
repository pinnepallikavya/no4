package com.example.nxtstayz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.nxtstayz.model.Hotel;
import com.example.nxtstayz.model.Room;
import com.example.nxtstayz.service.HotelJpaService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelJpaService hotelService;

    @Autowired
    public HotelController(HotelJpaService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return ResponseEntity.ok(hotels);
    }

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel createdHotel = hotelService.createHotel(hotel);
        return ResponseEntity.ok(createdHotel);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable int hotelId) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        return ResponseEntity.ok(hotel);
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable int hotelId, @RequestBody Hotel hotel) {
        Hotel updatedHotel = hotelService.updateHotel(hotelId, hotel);
        return ResponseEntity.ok(updatedHotel);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Void> deleteHotel(@PathVariable int hotelId) {
        hotelService.deleteHotel(hotelId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{hotelId}/rooms")
    public ResponseEntity<List<Room>> getHotelRooms(@PathVariable int hotelId) {
        List<Room> rooms = hotelService.getHotelRooms(hotelId);
        return ResponseEntity.ok(rooms);
    }

    public HotelJpaService getHotelService() {
        return hotelService;
    }
}
