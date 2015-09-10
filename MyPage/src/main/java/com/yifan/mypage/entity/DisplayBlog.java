package com.yifan.mypage.entity;

import javax.persistence.Column;

public class DisplayBlog {
	
	private String userName;
	private String blogTitle;
	private String blogContent;
	private String createTime;
	
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getBlogTitle() {
		return this.blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogContent() {
		return this.blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}


	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}


