package com.yifan.mypage.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yifan.mypage.entity.Blog;
import com.yifan.mypage.entity.DisplayBlog;
import com.yifan.mypage.entity.User;
import com.yifan.mypage.entity.UserBlog;
import com.yifan.mypage.service.BlogService;

@Controller
@RequestMapping(value="/blog")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value="post.do")
	public @ResponseBody Boolean blogPost(String blogTitle, String blogContent, HttpServletRequest request) {
		
		boolean flag = false;
		
		User user = new User();
		user = (User) request.getSession().getAttribute("user");
		
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String createTime = dateFormat.format( date ); 
		
		Blog blog = new Blog();
		UserBlog userBlog = new UserBlog();
		
		blog.setBlogTitle(blogTitle);
		blog.setBlogContent(blogContent);
		blog.setCreateTime(createTime);
		
		userBlog.setBlog(blog);
		userBlog.setUser(user);
		
		if (blogService.addBlog(blog, userBlog)) {			
			flag = true;
		};
		
		
		return flag;		
	}
	
	@RequestMapping(value="display.do")
	public @ResponseBody String blogDisplay(HttpServletRequest request, ModelMap modelMap) {
		
		User user = new User();
		user = (User) request.getSession().getAttribute("user");
		
		List<DisplayBlog> displayList = new ArrayList<DisplayBlog>();
		
		if (blogService.displayBlog(user) != null) {
			
			displayList = blogService.displayBlog(user);
			
			String displayListJson = JSON.toJSONString(displayList);			
			modelMap.addAttribute("displayListJson", displayListJson);
						
			
		}
		
		return "/blog";
		
	}
	
	

}
