package com.yifan.mypage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yifan.mypage.dao.CategoryDao;
import com.yifan.mypage.entity.Category;
import com.yifan.mypage.entity.ShowCategory;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao{
	
	@Autowired
	private SessionFactory sessionFactory;	

	@Override
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<ShowCategory> showAll() {
		List<ShowCategory> showCategoryList = new ArrayList<ShowCategory>();
		try {
			String hql = "FROM Category AS c";		
			Query query = this.getSession().createQuery(hql);	
			List<Category> categoryList = query.list();	
			for(int i = 0; i< categoryList.size(); i++) {
				ShowCategory showCategory = new ShowCategory();
				showCategory.setCategoryId(categoryList.get(i).getCategoryId());
				showCategory.setCategoryName(categoryList.get(i).getCategoryName());
				showCategoryList.add(showCategory);
			}
			if (categoryList.size() != 0) {
				
				return showCategoryList;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> saveSelected(List<Integer> categoryIds) {
		
		List<Category> categoryList = new ArrayList<Category>();
		try {
			for (int i = 0; i < categoryIds.size(); i++) {
				String hql = "FROM Category WHERE categoryId = " + categoryIds.get(i);				
				Query query = this.getSession().createQuery(hql);
				categoryList.addAll(query.list());					
			}
							
			if (categoryList.size() != 0) {				
				return categoryList;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
