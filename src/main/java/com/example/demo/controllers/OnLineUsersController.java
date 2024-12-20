package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.OnLineUsers;
import com.example.demo.ServiceImpl.OnLineUsersServiceImpl;
import com.example.demo.config.AppConstant;

@RestController
@CrossOrigin(AppConstant.FRONT_END_URL)
@RequestMapping("/api/onLineUser")
public class OnLineUsersController {

	@Autowired
	private OnLineUsersServiceImpl onLineUsersServiceImpl;

	// Add Online User
	@PostMapping("/add")
	public void addOnLineUser(@RequestBody OnLineUsers onLineUser) {

		String roomId = onLineUser.getRoomId();
		String userName = onLineUser.getUserName();

		onLineUsersServiceImpl.add(roomId, userName);

	}

	// Remove OnLine User

	@PostMapping("/remove")
	public void removeOnLineUser(@RequestBody OnLineUsers onLineUser) {

		String roomId = onLineUser.getRoomId();
		String userName = onLineUser.getUserName();
		onLineUsersServiceImpl.remove(roomId, userName);

	}

	// Get All OnLine Users
	@GetMapping("/getAll/{roomId}")
	public List<OnLineUsers> getAll(@PathVariable String roomId) {
		List<OnLineUsers> users = onLineUsersServiceImpl.getOnLineusers(roomId);
		return users;

	}
}
