package com.example.customerservicesystem.service;

import java.util.List;

import com.example.customerservicesystem.bean.RetParam;
import com.example.customerservicesystem.bean.User;

public interface UserService {

	public List<User> getUserByCondition(User user) throws Exception;

	public void updateUserByCondition(User user) throws Exception;

	public void insertUser(User auser) throws Exception;

	public void deleteUserByUserNo(String userNo)throws Exception;

}
