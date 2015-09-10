package com.yifan.mypage.service.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yifan.mypage.dao.UserDao;
import com.yifan.mypage.entity.User;
import com.yifan.mypage.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public Session getSession() {
		return userDao.getSession();
	}
	
	@Override
	public String addUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(String userEmail, String userPwd) {		
		return userDao.login(userEmail, userPwd);
	}

	


}
