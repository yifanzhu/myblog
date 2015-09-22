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
import com.yifan.mypage.entity.BlogCategory;
import com.yifan.mypage.entity.DisplayBlog;
import com.yifan.mypage.entity.ShowCategory;
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
	public Boolean addBlog(Blog blog, UserBlog userBlog, List<BlogCategory> bcList) {
		boolean flag = false;
		try {
		
			this.sessionFactory.getCurrentSession().save(blog);	
			this.sessionFactory.getCurrentSession().save(userBlog);	
			for(int i = 0; i < bcList.size(); i++) {
				this.sessionFactory.getCurrentSession().save(bcList.get(i));
			}
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
			
			String ubHql = "FROM UserBlog AS ub "
					+ "WHERE ub.user.userId = " + user.getUserId();
			
//			String hql = "SELECT ub.blog FROM User AS u, Blog AS b, UserBlog AS ub "
//					+ "WHERE ub.blog.blogId = b.blogId "
//					+ "AND ub.user.userId = u.userId "
//					+ "AND ub.user.userId = "+user.getUserId();
//					
			Query ubQuery = this.getSession().createQuery(ubHql);
			List<UserBlog> ubList = ubQuery.list();
			List<DisplayBlog> displayList = new ArrayList<DisplayBlog>();
			
			if ( ubList.size() != 0 ) {
				for (int i = 0; i < ubList.size(); i++) {
					DisplayBlog display = new DisplayBlog();
					display.setUserName(ubList.get(i).getUser().getUserName());
					display.setBlogId(ubList.get(i).getBlog().getBlogId());
					display.setBlogTitle(ubList.get(i).getBlog().getBlogTitle());
					display.setBlogContent(ubList.get(i).getBlog().getBlogContent());
					display.setCreateTime(ubList.get(i).getBlog().getCreateTime());
					
					
//					set category list
					String bcHql = "FROM BlogCategory AS bc "
							+ "WHERE bc.blog.blogId = " + ubList.get(i).getBlog().getBlogId();				
					Query bcQuery = this.getSession().createQuery(bcHql);
					List<BlogCategory> bcList = bcQuery.list();	
					List<ShowCategory> categoryList = new ArrayList<ShowCategory>();
					
					for (int j = 0; j < bcList.size(); j++) {
						ShowCategory category = new ShowCategory();
						category.setCategoryId(bcList.get(j).getCategory().getCategoryId());
						category.setCategoryName(bcList.get(j).getCategory().getCategoryName());
						categoryList.add(category);
					}
					
					display.setCategoryList(categoryList);
					
					
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

	@Override
	public DisplayBlog showPost(Integer blogId) {
		try {			
			
			List<DisplayBlog> displayList = new ArrayList<DisplayBlog>();
					
			String ubHql = "FROM UserBlog AS ub "
						+ "WHERE ub.blog.blogId = " + blogId;
			Query query = this.getSession().createQuery(ubHql);
			List<UserBlog> ubList = query.list();
			DisplayBlog showPost = new DisplayBlog();
			if (ubList.size() > 0) {
				showPost.setUserName(ubList.get(0).getUser().getUserName());
				showPost.setBlogId(ubList.get(0).getBlog().getBlogId());
				showPost.setBlogTitle(ubList.get(0).getBlog().getBlogTitle());
				showPost.setBlogContent(ubList.get(0).getBlog().getBlogContent());
				showPost.setCreateTime(ubList.get(0).getBlog().getCreateTime());
				
				String bcHql = "FROM BlogCategory AS bc "
						+ "WHERE bc.blog.blogId = " + blogId;				
				Query bcQuery = this.getSession().createQuery(bcHql);
				List<BlogCategory> bcList = bcQuery.list();	
				List<ShowCategory> categoryList = new ArrayList<ShowCategory>();				
				for (int i = 0; i < bcList.size(); i++) {
					ShowCategory category = new ShowCategory();
					category.setCategoryId(bcList.get(i).getCategory().getCategoryId());
					category.setCategoryName(bcList.get(i).getCategory().getCategoryName());
					categoryList.add(category);
				}
				
				showPost.setCategoryList(categoryList);
			}
			
			return showPost;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<DisplayBlog> displayCategoryPosts(Integer categoryId) {
		List<DisplayBlog> blogList = new ArrayList<DisplayBlog>();
		try {
			String hql = "FROM BlogCategory AS bc "
					+ "WHERE bc.category.categoryId = " + categoryId;				
			Query query = this.getSession().createQuery(hql);
			List<BlogCategory> bcList = query.list();
			
			for (int i = 0; i < bcList.size(); i++) {
				DisplayBlog blog = new DisplayBlog();
				blog.setBlogId(bcList.get(i).getBlog().getBlogId());
				blog.setBlogTitle(bcList.get(i).getBlog().getBlogTitle());
				blog.setBlogContent(bcList.get(i).getBlog().getBlogContent());
				blog.setCreateTime(bcList.get(i).getBlog().getCreateTime());
				blogList.add(blog);
			}
			return blogList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	

}
