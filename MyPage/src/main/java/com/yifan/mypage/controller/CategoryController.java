//package com.yifan.mypage.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.alibaba.fastjson.JSON;
//import com.yifan.mypage.entity.Category;
//import com.yifan.mypage.entity.User;
//import com.yifan.mypage.service.CategoryService;
//
//@Controller
//@RequestMapping(value="/category")
//public class CategoryController {
//	
//	@Autowired
//	private CategoryService categoryService;
//	
//	@RequestMapping(value="showAll.do")
//	public String categoryShowAll(ModelMap modelMap) {
//		
//		List<Category> categoryList = new ArrayList<Category>();
//		if (categoryService.showAll() != null) {
//						
//			categoryList = categoryService.showAll();
//			
//			String categoryListJson = JSON.toJSONString(categoryList);
//			modelMap.addAttribute("categoryListJson",categoryListJson);
//			
//			System.out.println(categoryListJson);
//			
//		}
//		
//		return "/blog";
//		
//	}
//	
//}
