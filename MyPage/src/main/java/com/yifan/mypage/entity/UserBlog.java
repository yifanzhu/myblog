package com.yifan.mypage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserBlog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_blog", catalog = "mypage")
public class UserBlog implements java.io.Serializable {

	// Fields

	private Integer ubId;
	private User user;
	private Blog blog;

	// Constructors

	/** default constructor */
	public UserBlog() {
	}

	/** full constructor */
	public UserBlog(User user, Blog blog) {
		this.user = user;
		this.blog = blog;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ub_id", unique = true, nullable = false)
	public Integer getUbId() {
		return this.ubId;
	}

	public void setUbId(Integer ubId) {
		this.ubId = ubId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ub_user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ub_blog_id", nullable = false)
	public Blog getBlog() {
		return this.blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

}