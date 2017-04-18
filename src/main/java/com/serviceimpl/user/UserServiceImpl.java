package com.serviceimpl.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entities.user.UserInfo;
import com.service.user.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	public UserInfo getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> getUsers(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUserById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
