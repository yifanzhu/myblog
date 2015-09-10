package com.yifan.mypage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSON;
import com.yifan.mypage.entity.User;
import com.yifan.mypage.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="test.do")
	public String userTest(String userName, String userPwd, String userEmail, String userGender, ModelMap modelMap) {
//		System.out.println(userName);
//		System.out.println(userPwd);
//		System.out.println(userEmail);
//		System.out.println(userGender);
		List<User> userList = new ArrayList<User>();
		
		User user = new User();
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		user.setUserEmail(userEmail);
		
		User user2 = new User();
		user2.setUserName("test");
		user2.setUserPwd("123asd");
		user2.setUserEmail("afawer");
		
		userList.add(user);
		userList.add(user2);
		
//		String userListJson = JSON.toJSONString(userList);
//		modelMap.addAttribute("userListJson", userListJson);
//		modelMap.addAttribute("userName", user2.getUserName());
				
		return "/index";
	}
	
	@RequestMapping(value="login.do")
	public @ResponseBody Boolean userLogin(String userEmail, String userPwd, HttpServletRequest request, ModelMap modelMap) {
		
		boolean flag = false;
		
		if ( userService.login(userEmail, userPwd) != null ) {
			
			User user = new User();		
			user = userService.login(userEmail, userPwd);
			request.getSession().setAttribute("user", user); 
			System.out.println(user.getUserName());			
//			modelMap.addAttribute("userName", user.getUserName());
			
			flag = true;					
		}
			
		return flag;
	}
	
	@RequestMapping(value="logout.do")
	public @ResponseBody Boolean userLogout(HttpServletRequest request) {
		
		boolean flag = false;
		
		if (request.getSession() != null) {
			request.getSession().removeAttribute("user");
			request.getSession().invalidate();	
			System.out.println("Session Invalid!");
			
			flag = true;
		}		
		return flag;
	}
}
