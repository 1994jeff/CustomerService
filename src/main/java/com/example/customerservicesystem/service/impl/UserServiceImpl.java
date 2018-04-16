package com.example.customerservicesystem.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.customerservicesystem.bean.User;
import com.example.customerservicesystem.dao.UserDao;
import com.example.customerservicesystem.service.UserService;
import com.example.customerservicesystem.untils.DomainNoUtils;
import com.example.customerservicesystem.untils.FileUtils;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	UserDao userDao;
	@Override
	public List<User> getUserByCondition(User user) throws Exception {
		try {
			return userDao.getUserByCondition(user);
		} catch (Exception e) {
			FileUtils.insertFile("hahatest", "getUserByCondition "+e.getMessage()+",e"+e.toString());
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void updateUserByCondition(User user) throws Exception {
		try {
			userDao.updateUserByCondition(user);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void insertUser(User auser) throws Exception {
		try {
			User s = new User();
			s.setName(auser.getName());
			if(userDao.getUserByCondition(s).size()>0){
				throw new Exception("添加失败! 用户名【"+auser.getName()+"】已存在！");
			}
			String userNo = DomainNoUtils.getNoByPreStr(DomainNoUtils.USER_NO);
			auser.setUserNo(userNo);
			Date d = new Date();
			auser.setCreateTime(d);
			userDao.insertUser(auser);
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void deleteUserByUserNo(String userNo) throws Exception {
		try {
			User user = new User();
			user.setUserNo(userNo);
			List<User> u = userDao.getUserByCondition(user);
			userDao.deleteUserByUserNo(userNo);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
