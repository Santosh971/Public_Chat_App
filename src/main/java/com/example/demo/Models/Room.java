package com.example.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "rooms")

@NoArgsConstructor
@AllArgsConstructor

public class Room {
        @Id
        private  String id;
        private String roomId;
        List<Message> messages = new ArrayList<>( );

    public void setId(String id) {
        this.id = id;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getId() {
        return id;
    }

    public String getRoomId() {
        return roomId;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
