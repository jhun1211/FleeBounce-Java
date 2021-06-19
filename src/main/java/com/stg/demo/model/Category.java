package com.stg.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "categories")
public class Category {
	@Id
	@GeneratedValue
	@NotNull
	@Column(name = "id")
	private int categoryID;

	@NotNull
	@NotBlank(message = "Tên danh mục không được để trống")
	@Size(max = 30, message = "Tên danh mục không được quá 30 ký tự!")
	@Column(name = "name")
	private String name;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
	private List<Products> products;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int categoryID, String name) {
		super();
		this.categoryID = categoryID;
		this.name = name;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}
}
