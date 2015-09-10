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
 * Category entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "category", catalog = "mypage")
public class Category implements java.io.Serializable {

	// Fields

	private Integer categoryId;
	private String categoryName;
	private Set<BlogCategory> blogCategories = new HashSet<BlogCategory>(0);

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(String categoryName, Set<BlogCategory> blogCategories) {
		this.categoryName = categoryName;
		this.blogCategories = blogCategories;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "category_id", unique = true, nullable = false)
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "category_name", length = 45)
	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
	public Set<BlogCategory> getBlogCategories() {
		return this.blogCategories;
	}

	public void setBlogCategories(Set<BlogCategory> blogCategories) {
		this.blogCategories = blogCategories;
	}

}