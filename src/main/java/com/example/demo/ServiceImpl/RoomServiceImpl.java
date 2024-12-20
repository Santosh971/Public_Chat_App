package com.example.demo.ServiceImpl;

import com.example.demo.Models.Message;
import com.example.demo.Models.Room;
import com.example.demo.repositories.RoomRepo;
import com.example.demo.services.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomServices {
    @Autowired
    private RoomRepo roomRepo;


    //Create  New Room
    @Override
    public ResponseEntity<?> createRoom(String roomId) {
        //        Room already exist
        if (roomRepo.findByRoomId(roomId) != null) {
            return ResponseEntity.badRequest().body("Room Already Exist...");
        }

        //        Create New Room

        Room room = new Room();

        room.setRoomId(roomId);
        Room savedRoom = roomRepo.save(room);
        System.out.println("Room created");
        return ResponseEntity.status(HttpStatus.CREATED).body(room);
    }

    // Get Room

    public ResponseEntity<?> getRoom(String roomId) {
        Room room = roomRepo.findByRoomId(roomId);
        System.out.println("In getroom service...");
        if (room != null) {
            return ResponseEntity.status(HttpStatus.OK).body(room);
        }
        return ResponseEntity.badRequest().body("Room Not Exist...");
    }

    //    Get Messages

    public ResponseEntity<?> getMessages(String roomId) {
        Room room = roomRepo.findByRoomId(roomId);

        if (room == null) {
            return ResponseEntity.badRequest().body("Room Not Exist....");
        }
        if (room.getMessages() == null) {
            return ResponseEntity.badRequest().body("No Messages");
        }

        List<Message> messages = room.getMessages();
        return ResponseEntity.status(HttpStatus.OK).body(messages);
    }
}
