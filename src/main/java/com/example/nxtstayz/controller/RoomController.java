package com.example.nxtstayz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.nxtstayz.model.Hotel;
import com.example.nxtstayz.model.Room;
import com.example.nxtstayz.service.RoomJpaService;

@RestController
@RequestMapping("/hotels/rooms")
public class RoomController {

    private final RoomJpaService roomService;

    public RoomController(RoomJpaService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room createdRoom = roomService.createRoom(room);
        return ResponseEntity.ok(createdRoom);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<Room> getRoomById(@PathVariable int roomId) {
        Room room = roomService.getRoomById(roomId);
        return ResponseEntity.ok(room);
    }

    @PutMapping("/{roomId}")
    public ResponseEntity<Room> updateRoom(@PathVariable int roomId, @RequestBody Room room) {
        Room updatedRoom = roomService.updateRoom(roomId, room);
        return ResponseEntity.ok(updatedRoom);
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<Void> deleteRoom(@PathVariable int roomId) {
        roomService.deleteRoom(roomId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{roomId}/hotel")
    public ResponseEntity<Hotel> getRoomHotel(@PathVariable int roomId) {
        Hotel hotel = roomService.getRoomById(roomId);
        return ResponseEntity.ok(hotel);
    }

    public RoomJpaService getRoomService() {
        return roomService;
    }
}