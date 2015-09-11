package com.yifan.mypage.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yifan.mypage.dao.CategoryDao;
import com.yifan.mypage.entity.Category;
import com.yifan.mypage.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public Session getSession() {
		return categoryDao.getSession();
	}

	@Override
	public List<Category> showAll() {		
		return categoryDao.showAll();
	}

}
