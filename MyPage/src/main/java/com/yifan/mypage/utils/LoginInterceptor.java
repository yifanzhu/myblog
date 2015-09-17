package com.yifan.mypage.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yifan.mypage.entity.User;

@Repository
public class LoginInterceptor implements HandlerInterceptor{
	
	String visitPage[] = {"index.jsp", "login.do", "logout.do", "showErrorPage.do", "showBlogPage.do", "show.do"};

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		
		//get url  
        String reqUrl=request.getRequestURI().replace(request.getContextPath(), "");  
        
        //游客未登录可访问的页面
        for (int i = 0; i < visitPage.length; i++) {          	
        	if(reqUrl.contains(visitPage[i])) {  
                return true;  
            }    	
        } 
        	
        HttpSession session=request.getSession();             
        User user = (User) session.getAttribute("user");  
           
        if(user == null || "".equals(user.toString())) {             
            response.sendRedirect("showErrorPage.do");  
        }  
        
        return true;  
	}

}
