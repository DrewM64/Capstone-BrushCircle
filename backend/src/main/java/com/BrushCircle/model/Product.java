package com.BrushCircle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name = "title")

	private String title; //name of artwork

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "price")
	private Integer price; //cost

	@Column(name = "style")
	private String style; //art style

	@Column(name = "featured")
	private boolean featured;

	@Column(name = "description")
	private String description; //art description

	@Column(name = "width")
	private int width;

	@Column(name = "length")
	private int length;

	@Column(name = "tags")
	private String tags;

	@Column(name = "filename")
	private String filename; //image file name

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	private User user;

	public Product() {
	}

	public Product(String title, Integer price, String style, boolean featured, String description, int width, int length, String tags) {
		super();
		this.title = title;
		this.price = price;
		this.style = style;
		this.featured = featured;
		this.description = description;
		this.width = width;
		this.length = length;
		this.tags = tags;
	}

	public Product(String title, LocalDate date, Integer price, String style, boolean featured, String description, int width, int length, String tags) {
		super();
		this.title = title;
		this.date = date;
		this.price = price;
		this.style = style;
		this.featured = featured;
		this.description = description;
		this.width = width;
		this.length = length;
		this.tags = tags;
	}

	public Product(String title, LocalDate date, Integer price, String style, boolean featured, String description, int width, int length, String tags, String filename) {
		super();
		this.title = title;
		this.date = date;
		this.price = price;
		this.style = style;
		this.featured = featured;
		this.description = description;
		this.width = width;
		this.length = length;
		this.tags = tags;
		this.filename = filename;
	}

	public Product(String title, LocalDate date, Integer price, String style, boolean featured, String description, int width, int length, String tags, String filename, User user) {
		super();
		this.title = title;
		this.date = date;
		this.price = price;
		this.style = style;
		this.featured = featured;
		this.description = description;
		this.width = width;
		this.length = length;
		this.tags = tags;
		this.filename = filename;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public boolean isFeatured() {
		return featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Product{" +
				", title='" + title + '\'' +
				", price=" + price.toString() +
				", style='" + style + '\'' +
				", featured=" + featured +
				", description='" + description + '\'' +
				", width=" + width +
				", length=" + length +
				", tags='" + tags + '\'' +
				", filename='" + filename + '\'' +
				'}';
	}
}
