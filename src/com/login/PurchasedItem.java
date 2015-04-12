package com.login;

public class PurchasedItem {
	
	private int purchase_id, quantity;
	private String title, manufacturer;
	private float price;
	
	public PurchasedItem() {
		
	}

	public PurchasedItem(int purchase_id, int quantity, String title,
			String manufacturer, float price) {
		this.purchase_id = purchase_id;
		this.quantity = quantity;
		this.title = title;
		this.manufacturer = manufacturer;
		this.price = price;
	}

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
