package com.yifan.mypage.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yifan.mypage.dao.CategoryDao;
import com.yifan.mypage.entity.Category;
import com.yifan.mypage.entity.User;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao{
	
	@Autowired
	private SessionFactory sessionFactory;	

	@Override
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<Category> showAll() {
		
		try {
			String hql = "FROM Category";		
			Query query = this.getSession().createQuery(hql);	
			List<Category> categoryList = query.list();	
			System.out.println(categoryList.size());
			if (categoryList.size() != 0) {
				
				return categoryList;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
