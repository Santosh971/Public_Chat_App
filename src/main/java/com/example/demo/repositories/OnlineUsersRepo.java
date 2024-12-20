package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.Models.OnLineUsers;

public interface OnlineUsersRepo extends MongoRepository<OnLineUsers, String> {
	List<OnLineUsers> findAllByRoomId(String roomId);

	void deleteByRoomIdAndUserName(String roomId, String userName);
}
