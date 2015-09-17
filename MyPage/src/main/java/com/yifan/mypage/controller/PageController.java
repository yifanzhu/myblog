package com.yifan.mypage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.yifan.mypage.entity.Category;
import com.yifan.mypage.entity.DisplayBlog;
import com.yifan.mypage.entity.ShowCategory;
import com.yifan.mypage.entity.User;
import com.yifan.mypage.service.BlogService;
import com.yifan.mypage.service.CategoryService;

@Controller
@RequestMapping(value="/page")
public class PageController {
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="showBlogPage.do")
	public String showBlogPage (HttpServletRequest request, ModelMap modelMapBlog, ModelMap modelMapCategory) {
		
//		Display Blog
		User user = new User();
		user = (User) request.getSession().getAttribute("user");
		
		List<DisplayBlog> displayList = new ArrayList<DisplayBlog>();
		
		if (blogService.displayBlog(user) != null) {
			
			displayList = blogService.displayBlog(user);
			
			String displayListJson = JSON.toJSONString(displayList);			
			modelMapBlog.addAttribute("displayListJson", displayListJson);
			System.out.println(displayListJson);			
		}
		
//		Show Category
		List<ShowCategory> categoryList = new ArrayList<ShowCategory>();
		if (categoryService.showAll() != null) {
						
			categoryList = categoryService.showAll();
					
			String categoryListJson = JSON.toJSONString(categoryList);
			modelMapCategory.addAttribute("categoryListJson",categoryListJson);
			
		}
		return "/blog";
	}
	
	@RequestMapping(value="showErrorPage.do")
	public String showErrorPage () {
		return "/error";
	}

}
