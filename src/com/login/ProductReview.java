package com.login;

public class ProductReview {
	
	private String manufacturer, title, image, comment;
	
	public ProductReview() {
		
	}

	public ProductReview(String manufacturer, String title, String image,
			String comment) {
		this.manufacturer = manufacturer;
		this.title = title;
		this.image = image;
		this.comment = comment;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
