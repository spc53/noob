package com.lcu.res.service;

import com.lcu.res.po.User;

public interface UserService {

	User loginCheck(User user);

	void createUser(User user);

	int updateUserInfo(User user);

	User selectByUserName(String userName);

	int updatePw(User user);

	String selectPwByName(String userName);
	
}
