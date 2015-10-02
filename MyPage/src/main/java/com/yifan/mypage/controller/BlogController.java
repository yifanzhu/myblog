package com.yifan.mypage.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;a

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yifan.mypage.entity.Blog;
import com.yifan.mypage.entity.BlogCategory;
import com.yifan.mypage.entity.Category;
import com.yifan.mypage.entity.DisplayBlog;
import com.yifan.mypage.entity.ShowCategory;
import com.yifan.mypage.entity.User;
import com.yifan.mypage.entity.UserBlog;
import com.yifan.mypage.service.BlogService;
import com.yifan.mypage.service.CategoryService;

@Controller
@RequestMapping(value="/blog")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="post.do")
	public @ResponseBody Boolean blogPost(String blogTitle, String blogContent, String categoryStrId,
			HttpServletRequest request, ModelMap modelMap) {
		
		boolean flag = false;
		
//		define createTime
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String createTime = dateFormat.format( date ); 
		
//		set Blog
		Blog blog = new Blog();
		
		blog.setBlogTitle(blogTitle);
		blog.setBlogContent(blogContent);
		blog.setCreateTime(createTime);
		
//		set UserBlog
		User user = new User();
		user = (User) request.getSession().getAttribute("user");
		
		UserBlog userBlog = new UserBlog();
		
		userBlog.setBlog(blog);
		userBlog.setUser(user);
		
//		set BlogCategory		
		String[] categoryStrIds = categoryStrId.split(",");
		List<Integer> categoryIds = new ArrayList<Integer>();		
		for (int i = 0; i < categoryStrIds.length; i++)
		{		
			categoryIds.add(Integer.parseInt(categoryStrIds[i]));			
		}
		
		
		List<Category> categoryList = new ArrayList<Category>();
		if (categoryService.saveSelected(categoryIds) != null) {
			categoryList = categoryService.saveSelected(categoryIds);			
		}
		
	
		List<BlogCategory> bcList = new ArrayList<BlogCategory>();
		for (int i = 0; i < categoryList.size(); i++) {
			BlogCategory blogCategory = new BlogCategory();
			blogCategory.setBlog(blog);
			blogCategory.setCategory(categoryList.get(i));
			bcList.add(blogCategory);
		}		
		
		
		if (blogService.addBlog(blog, userBlog, bcList)) {			
			flag = true;
			
//			List<DisplayBlog> displayListu = new ArrayList<DisplayBlog>();
//			displayListu = blogService.displayBlog(user);
//			
//			String displayListJsonu = JSON.toJSONString(displayListu);			
//			modelMap.addAttribute("displayListJsonu", displayListJsonu);
//			System.out.println(displayListJsonu);
//			
		};
		
		
		return flag;		
	}
	
	@RequestMapping(value="display.do")
	public String blogDisplay(HttpServletRequest request, ModelMap modelMap) {
		
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
	
	@RequestMapping(value="show.do")
	public String postShow(Integer blogId, ModelMap modelMapPost, ModelMap modelMapCategory) {
		
		DisplayBlog showPost = new DisplayBlog();
		if (blogService.showPost(blogId) != null) {
			showPost = blogService.showPost(blogId);
			
			String showPostJson = JSON.toJSONString(showPost);
			modelMapPost.addAttribute("showPostJson", showPostJson);
		}
		
//		Show All Category
		List<ShowCategory> categoryList = new ArrayList<ShowCategory>();
		if (categoryService.showAll() != null) {
						
			categoryList = categoryService.showAll();
					
			String categoryListJson = JSON.toJSONString(categoryList);
			modelMapCategory.addAttribute("categoryListJson",categoryListJson);			
		}
		
		return "/post_show";
		
	}
	
	@RequestMapping(value="categoryPosts.do")
	public String categoryPosts (Integer categoryId, ModelMap modelMapPosts, ModelMap modelMapCategory) {
		List<DisplayBlog> blogList = new ArrayList<DisplayBlog>();
		if (blogService.displayCategoryPosts(categoryId) != null) {
			blogList = blogService.displayCategoryPosts(categoryId);
			
			String blogListJson = JSON.toJSONString(blogList);			
			modelMapPosts.addAttribute("blogListJson", blogListJson);
		}
		
//		Show All Category
		List<ShowCategory> categoryList = new ArrayList<ShowCategory>();
		if (categoryService.showAll() != null) {
						
			categoryList = categoryService.showAll();
					
			String categoryListJson = JSON.toJSONString(categoryList);
			modelMapCategory.addAttribute("categoryListJson",categoryListJson);			
		}
		return "/category_posts";
		
	}
	
	

}
