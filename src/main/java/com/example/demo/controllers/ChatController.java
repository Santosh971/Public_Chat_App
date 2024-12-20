package com.example.demo.controllers;

import com.example.demo.Models.Message;
import com.example.demo.Models.Room;
import com.example.demo.config.AppConstant;
import com.example.demo.payload.MessageRequest;
import com.example.demo.repositories.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@CrossOrigin(AppConstant.FRONT_END_URL)
@RestController
public class ChatController {
	@Autowired
	private RoomRepo roomRepo;

	// For sending and receiving messages
	@MessageMapping("/sendMessage/{roomId}")
	@SendTo("/topic/room/{roomId}")
	public Message sendMessage(@DestinationVariable String roomId, @RequestBody MessageRequest request) {

		System.out.println("In message service");
		Room room = roomRepo.findByRoomId(roomId);
		Message message = new Message();

		System.out.println("Request sender : " + request.getSender());
		System.out.println("Request sender : " + request.getRoomId());
		message.setContent(request.getContent());
		message.setSender(request.getSender());
		message.setTimeStamp(LocalDateTime.now());

		if (room != null) {
			room.getMessages().add(message);
			roomRepo.save(room);
		} else {
			throw new RuntimeException("Room Not Found");
		}

		System.out.println(message.getSender());
		System.out.println(message.getContent());
		return message;
	}
}
