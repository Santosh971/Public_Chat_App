package com.example.demo.services;

import java.util.List;

import com.example.demo.Models.OnLineUsers;

public interface OnLineUsersService {
	public void add(String roomId, String userName);
	
	public void remove(String roomId, String userName);
	
	public List<OnLineUsers> getOnLineusers (String roomId);

}
