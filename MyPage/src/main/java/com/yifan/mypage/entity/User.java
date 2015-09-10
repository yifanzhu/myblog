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
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "mypage")
public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String userEmail;
	private String userPwd;
	private Set<UserBlog> userBlogs = new HashSet<UserBlog>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userName, String userEmail, String userPwd) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPwd = userPwd;
	}

	/** full constructor */
	public User(String userName, String userEmail, String userPwd,
			Set<UserBlog> userBlogs) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPwd = userPwd;
		this.userBlogs = userBlogs;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "user_name", nullable = false, length = 45)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_email", nullable = false, length = 45)
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "user_pwd", nullable = false, length = 45)
	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserBlog> getUserBlogs() {
		return this.userBlogs;
	}

	public void setUserBlogs(Set<UserBlog> userBlogs) {
		this.userBlogs = userBlogs;
	}

}