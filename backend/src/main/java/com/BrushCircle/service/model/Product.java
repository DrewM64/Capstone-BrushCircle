package com.BrushCircle.service.model;

import javax.persistence.*;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer price; //cost
	private String productTitle; //name of artwork
	private String productStyle; //art style
	private String description; //art description
	private String filename; //image file name
	private String artistName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artist")
	private Artist artist;

	public Product() {}

	public Product(Integer price, String artistName, String productTitle, String productStyle, String description, String filename, Artist artist) {
		super();
		this.price = price;
		this.artistName = artistName;
		this.productTitle = productTitle;
		this.productStyle = productStyle;
		this.description = description;
		this.filename = filename;
		this.artist = artist;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductStyle() {
		return productStyle;
	}

	public void setProductStyle(String productStyle) {
		this.productStyle = productStyle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

}
