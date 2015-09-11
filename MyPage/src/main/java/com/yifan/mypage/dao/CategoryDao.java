package com.yifan.mypage.dao;

import java.util.List;

import org.hibernate.Session;

import com.yifan.mypage.entity.Category;
import com.yifan.mypage.entity.User;

public interface CategoryDao {

	public Session getSession();
	public List<Category> showAll();

}
