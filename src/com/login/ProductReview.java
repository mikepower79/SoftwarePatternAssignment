package com.login;

import java.sql.Timestamp;

public class ProductReview {
	
	private String name, comment, product;
	private Timestamp date;
	private int rating;
	
	public ProductReview() {
		
	}

	public ProductReview(String name, String product, String comment, Timestamp date, int rating) {
		this.name = name;
		this.product = product;
		this.comment = comment;
		this.date = date;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}
}