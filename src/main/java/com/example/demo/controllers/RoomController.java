package com.example.demo.controllers;

import com.example.demo.ServiceImpl.RoomServiceImpl;
import com.example.demo.config.AppConstant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(AppConstant.FRONT_END_URL)
@RequestMapping("/api/room")
public class RoomController {
	@Autowired
	private RoomServiceImpl roomService;

	// Create Room
	@PostMapping("/createRoom")
	public ResponseEntity<?> createRoom(@RequestBody String roomId) {
		System.out.println("In room controller...");
		return roomService.createRoom(roomId);
	}

	// Get Room
	@GetMapping("/getRoom/{roomId}")
	public ResponseEntity<?> getRoom(@PathVariable String roomId) {
		System.out.println("In get room controller...");
		return roomService.getRoom(roomId);
	}

	// Get Messages
	@GetMapping("/getMessages/{roomId}")
	public ResponseEntity<?> getMessages(@PathVariable String roomId) {
		return roomService.getMessages(roomId);
	}

}
