package com.example.nxtstayz.service;

import java.util.List;

import com.example.nxtstayz.model.Room;

public interface RoomJpaService {
    List<Room> getAllRooms();

    Room getRoomById(int roomId);

    Room createRoom(Room room);

    Room updateRoom(int roomId, Room room);

    void deleteRoom(int roomId);
}
