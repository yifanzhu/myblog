package com.yifan.mypage.service;

import java.util.List;

import org.hibernate.Session;

import com.yifan.mypage.entity.Category;
import com.yifan.mypage.entity.ShowCategory;

public interface CategoryService {
	
	public Session getSession();
	
	public List<ShowCategory> showAll();
	public List<Category> saveSelected(List<Integer> categoryIds);

}
