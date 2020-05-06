package com.lcu.res.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.lcu.res.po.User;

@Repository
@Mapper
public interface UserMapper {

	User selectBynameAndpsd(User user);

	void createUser(User user);

	void updateUserInfo(User user);

	User selectByUserName(String userName);

	void updatePw(User user);

	String selectPwByName(String userName);

}
