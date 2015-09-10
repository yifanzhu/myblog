package com.yifan.mypage.service;

import org.hibernate.Session;

import com.yifan.mypage.entity.User;

public interface UserService {
	
	public Session getSession();
	
	public String addUser();
	public String deleteUser(Integer id);
	public String updateUser(Integer id);
	public User login(String userName, String userPwd);	
}
