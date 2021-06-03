package com.stg.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;

import com.stg.demo.validate.CheckID;

@Entity(name = "products")
public class Products {
	@Id
	@GeneratedValue
	int id;
	@NotBlank
	@Size(min = 3, max = 50)
	String name;
	@NotNull
	@Pattern(regexp = "https?:\\/\\/.*\\.(?:png|jpg)", message = "Sai định dạng hình ảnh")
	String images;
	@NotNull
	Date created = new Date((new java.util.Date()).getTime());
	@NotNull
	@Min(1000)
	@Max(1000000)
	double price;
	@NotNull
	String description = "Haha";
	@CheckID
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false, foreignKey = @ForeignKey(name = "category_products"))
	Category category;

	public Products() {
		super();
	}

	public Products(int id, String name, String images, Date created, double price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.images = images;
		this.created = created;
		this.price = price;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
