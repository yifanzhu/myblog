package com.yifan.mypage.entity;

import java.util.List;

public class DisplayBlog {
	
	private String userName;
	private Integer blogId;
	private String blogTitle;
	private String blogContent;
	private String createTime;
	private List<ShowCategory> bcList;
	
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

	public List<ShowCategory> getCategoryList() {
		return bcList;
	}

	public void setCategoryList(List<ShowCategory> categoryList) {
		this.bcList = categoryList;
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

}


