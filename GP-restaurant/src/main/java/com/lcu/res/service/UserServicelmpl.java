package com.lcu.res.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcu.res.dao.UserMapper;
import com.lcu.res.po.User;

@Service
public class UserServicelmpl implements UserService {

	@Autowired
	UserMapper usermapper;

	@Override
	public User loginCheck(User user) {
		return usermapper.selectBynameAndpsd(user);
	}

	@Override
	public void createUser(User user) {
		usermapper.createUser(user);
	}

	@Override
	public int updateUserInfo(User user) {
		usermapper.updateUserInfo(user);
		return 1;
	}

	@Override
	public User selectByUserName(String userName) {
		return usermapper.selectByUserName(userName);
	}

	@Override
	public int updatePw(User user) {
		usermapper.updatePw(user);
		return 1;
	}

	@Override
	public String selectPwByName(String userName) {
		return usermapper.selectPwByName(userName);
	}
	
	
}
