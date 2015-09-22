package com.yifan.mypage.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yifan.mypage.dao.BlogDao;
import com.yifan.mypage.entity.Blog;
import com.yifan.mypage.entity.BlogCategory;
import com.yifan.mypage.entity.DisplayBlog;
import com.yifan.mypage.entity.User;
import com.yifan.mypage.entity.UserBlog;
import com.yifan.mypage.service.BlogService;

@Service("blogService")
public class BlogServiceImpl implements BlogService{
	
	@Autowired
	private BlogDao blogDao;
	

	@Override
	public Session getSession() {
		return blogDao.getSession();
	}
	
	@Override
	public Boolean addBlog(Blog blog, UserBlog userBlog, List<BlogCategory> bcList) {
		return blogDao.addBlog(blog, userBlog, bcList);
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
		return blogDao.displayBlog(user);
	}

	@Override
	public DisplayBlog showPost(Integer blogId) {
		return blogDao.showPost(blogId);
	}

	@Override
	public List<DisplayBlog> displayCategoryPosts(Integer categoryId) {
		return blogDao.displayCategoryPosts(categoryId);
	}

	

}
