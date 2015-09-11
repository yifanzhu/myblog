package com.yifan.mypage.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yifan.mypage.dao.UserDao;
import com.yifan.mypage.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
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
	public User login(String userEamil, String userPwd) {
		
		User user = new User();
		try {
			String hql = "FROM User AS u WHERE u.userEmail = '" + userEamil + "' AND u.userPwd = '" + userPwd + "'";
//			StringBuffer sb = new StringBuffer(" select userName from User ");
//			Query query = this.getSession().createQuery(sb.toString());
			Query query = this.getSession().createQuery(hql);
			List<User> userList = query.list();
//			System.out.println(userEamil + " " + userPwd);
			
//				System.out.println(userList.get(i).getUserName());
				if ( userList.size() != 0 ) {
									
					System.out.println("Login Success!");
					user = userList.get(0);					
					
				} else {
					System.out.println("Wrong Email or Password!");
					user = null;
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;	
	}
	
	
	
}
