package com.yifan.mypage.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Blog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "blog", catalog = "mypage")
public class Blog implements java.io.Serializable {

	// Fields

	private Integer blogId;
	private String blogTitle;
	private String blogContent;
	private String createTime;
	private String updateTime;
	private Set<BlogCategory> blogCategories = new HashSet<BlogCategory>(0);
	private Set<UserBlog> userBlogs = new HashSet<UserBlog>(0);

	// Constructors

	/** default constructor */
	public Blog() {
	}

	/** full constructor */
	public Blog(String blogTitle, String blogContent, String createTime,
			String updateTime, Set<BlogCategory> blogCategories,
			Set<UserBlog> userBlogs) {
		this.blogTitle = blogTitle;
		this.blogContent = blogContent;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.blogCategories = blogCategories;
		this.userBlogs = userBlogs;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "blog_id", unique = true, nullable = false)
	public Integer getBlogId() {
		return this.blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	@Column(name = "blog_title", length = 45)
	public String getBlogTitle() {
		return this.blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	@Column(name = "blog_content", length = 45)
	public String getBlogContent() {
		return this.blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	@Column(name = "create_time", length = 45)
	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Column(name = "update_time", length = 45)
	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "blog")
	public Set<BlogCategory> getBlogCategories() {
		return this.blogCategories;
	}

	public void setBlogCategories(Set<BlogCategory> blogCategories) {
		this.blogCategories = blogCategories;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "blog")
	public Set<UserBlog> getUserBlogs() {
		return this.userBlogs;
	}

	public void setUserBlogs(Set<UserBlog> userBlogs) {
		this.userBlogs = userBlogs;
	}

}