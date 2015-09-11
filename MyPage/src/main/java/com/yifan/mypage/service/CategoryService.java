package com.yifan.mypage.service;

import java.util.List;

import org.hibernate.Session;

import com.yifan.mypage.entity.Category;

public interface CategoryService {
	
	public Session getSession();
	
	public List<Category> showAll();

}
