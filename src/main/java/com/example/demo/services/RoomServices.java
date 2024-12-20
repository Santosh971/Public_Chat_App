package com.example.demo.services;

import org.springframework.http.ResponseEntity;

public interface RoomServices {
    public ResponseEntity<?> createRoom(String roomId);
    public ResponseEntity<?> getRoom(String roomId);
    public ResponseEntity<?> getMessages(String roomId);

}
