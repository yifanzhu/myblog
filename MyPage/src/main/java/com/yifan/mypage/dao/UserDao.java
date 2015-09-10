package com.yifan.mypage.dao;

import org.hibernate.Session;

import com.yifan.mypage.entity.User;

public interface UserDao {
	
	public Session getSession();
	public String addUser();
	public String deleteUser(Integer id);
	public String updateUser(Integer id);
	public User login(String userEmail, String userPwd);
	

}
