package com.yifan.mypage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.yifan.mypage.entity.DisplayBlog;
import com.yifan.mypage.entity.User;
import com.yifan.mypage.service.BlogService;

@Controller
@RequestMapping(value="/page")
public class PageController {
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value="showBlogPage.do")
	public String showBlogPage (HttpServletRequest request, ModelMap modelMap) {
		
		User user = new User();
		user = (User) request.getSession().getAttribute("user");
		
		List<DisplayBlog> displayList = new ArrayList<DisplayBlog>();
		
		if (blogService.displayBlog(user) != null) {
			
			displayList = blogService.displayBlog(user);
			
			String displayListJson = JSON.toJSONString(displayList);			
			modelMap.addAttribute("displayListJson", displayListJson);
			
			System.out.println(displayListJson);
		}
		return "/blog";
	}
	
	@RequestMapping(value="showErrorPage.do")
	public String showErrorPage () {
		return "/error";
	}

}
