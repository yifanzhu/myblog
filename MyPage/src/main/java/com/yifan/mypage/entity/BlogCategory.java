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
 * BlogCategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "blog_category", catalog = "mypage")
public class BlogCategory implements java.io.Serializable {

	// Fields

	private Integer bcId;
	private Blog blog;
	private Category category;

	// Constructors

	/** default constructor */
	public BlogCategory() {
	}

	/** full constructor */
	public BlogCategory(Blog blog, Category category) {
		this.blog = blog;
		this.category = category;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "bc_id", unique = true, nullable = false)
	public Integer getBcId() {
		return this.bcId;
	}

	public void setBcId(Integer bcId) {
		this.bcId = bcId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bc_blog_id", nullable = false)
	public Blog getBlog() {
		return this.blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bc_category_id", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}