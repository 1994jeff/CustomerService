package com.example.customerservicesystem.dao;

import java.util.List;

import com.example.customerservicesystem.bean.RetParam;
import com.example.customerservicesystem.bean.User;

public interface UserDao {

	List<User> getUserByCondition(User user);

	void updateUserByCondition(User user);

	void insertUser(User auser);

	void deleteUserByUserNo(String userNo);

	User getUserByOpenId(String openId);

}
