package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.OnLineUsers;
import com.example.demo.repositories.OnlineUsersRepo;
import com.example.demo.services.OnLineUsersService;

@Service
public class OnLineUsersServiceImpl implements OnLineUsersService {

	@Autowired
	private OnlineUsersRepo onlineuserRepo;

	@Override
	public void add(String roomId, String userName) {
		// TODO Auto-generated method stub

		OnLineUsers user = new OnLineUsers();
		user.setRoomId(roomId);
		user.setUserName(userName);

		onlineuserRepo.save(user);

	}

	@Override
	public void remove(String roomId, String userName) {
		// TODO Auto-generated method stub
		onlineuserRepo.deleteByRoomIdAndUserName(roomId, userName);

	}

	@Override
	public List<OnLineUsers> getOnLineusers(String roomId) {
		// TODO Auto-generated method stub

		List<OnLineUsers> onLineUsers = onlineuserRepo.findAllByRoomId(roomId);
		return onLineUsers;
	}

}
