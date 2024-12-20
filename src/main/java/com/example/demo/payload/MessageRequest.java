package com.example.demo.payload;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class MessageRequest {
   private String roomId;
   private  String content;
   private String sender;


    public MessageRequest(String roomId, String content, String sender) {
        this.roomId = roomId;
        this.content = content;
        this.sender = sender;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }


}
