package com.BrushCircle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title; //name of artwork
	private Date date;
	private Integer price; //cost
	private String style; //art style
	private boolean featured;
	private String description; //art description
	private int width;
	private int length;
	private String tags;
	private String filename; //image file name
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	private User user;

	public Product() {
	}

	public Product(String title, Date date, Integer price, String style, boolean featured, String description, int width, int length, String tags, String filename) {
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

	public Product(String title, Date date, Integer price, String style, boolean featured, String description, int width, int length, String tags, String filename, User user) {
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
}
