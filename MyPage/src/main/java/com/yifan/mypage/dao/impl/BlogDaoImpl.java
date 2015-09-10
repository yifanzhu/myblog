package com.yifan.mypage.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yifan.mypage.dao.BlogDao;
import com.yifan.mypage.entity.Blog;
import com.yifan.mypage.entity.DisplayBlog;
import com.yifan.mypage.entity.User;
import com.yifan.mypage.entity.UserBlog;

@Repository("blogDao")
public class BlogDaoImpl implements BlogDao{
	
	@Autowired 
	SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public Boolean addBlog(Blog blog, UserBlog userBlog) {
		boolean flag = false;
		try {
		
			this.sessionFactory.getCurrentSession().save(blog);	
			this.sessionFactory.getCurrentSession().save(userBlog);	
			flag = true;
			System.out.println("Post Successfully!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public String deleteBlog(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateBlog(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DisplayBlog> displayBlog(User user) {
		
		try {
			
			String hql = "FROM UserBlog AS ub "
					+ "WHERE ub.user.userId = " + user.getUserId();
			
//			String hql = "SELECT ub.blog FROM User AS u, Blog AS b, UserBlog AS ub "
//					+ "WHERE ub.blog.blogId = b.blogId "
//					+ "AND ub.user.userId = u.userId "
//					+ "AND ub.user.userId = "+user.getUserId();
//					
			Query query = this.getSession().createQuery(hql);
			List<UserBlog> ubList = query.list();
			List<DisplayBlog> displayList = new ArrayList<DisplayBlog>();
			
			if ( ubList.size() != 0 ) {
				for(int i=0;i<ubList.size();i++) {
					DisplayBlog display = new DisplayBlog();
					display.setUserName(ubList.get(i).getUser().getUserName());
					display.setBlogTitle(ubList.get(i).getBlog().getBlogTitle());
					display.setBlogContent(ubList.get(i).getBlog().getBlogContent());
					display.setCreateTime(ubList.get(i).getBlog().getCreateTime());
					displayList.add(display);
				}				
				
				return displayList;				
				
			} else {
				System.out.println("No post!");
				return null;
			}
								
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
				
	}

	

}
