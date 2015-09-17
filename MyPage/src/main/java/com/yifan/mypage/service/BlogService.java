package com.yifan.mypage.service;

import java.util.List;

import org.hibernate.Session;

import com.yifan.mypage.entity.Blog;
import com.yifan.mypage.entity.BlogCategory;
import com.yifan.mypage.entity.DisplayBlog;
import com.yifan.mypage.entity.User;
import com.yifan.mypage.entity.UserBlog;

public interface BlogService {
	
	public Session getSession();
	
	public Boolean addBlog(Blog blog, UserBlog userBlog, List<BlogCategory> bcList);
	public String deleteBlog(Integer id);
	public String updateBlog(Integer id);
	public List<DisplayBlog> displayBlog(User user);
	public DisplayBlog showPost(Integer blogId);

}
