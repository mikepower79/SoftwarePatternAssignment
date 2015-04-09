package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class FinalCheckout extends ActionSupport {

	private static final long serialVersionUID = 1L;
	ArrayList<Item> itemList;
	ArrayList<PurchasesBean> purchasesList;
	private String email,title,manufacturer,category;
	private int purchases_id, id,ammount,quantity;
	private float price;
	private ArrayList<User> userList;

	public String execute() {
		String ret = ERROR;
		Connection conn1 = null;
		itemList =  new ArrayList<Item>();
		purchasesList = new ArrayList<PurchasesBean>();
		userList = new ArrayList<User>();

		try {
			String URL = "jdbc:mysql://localhost/paddyassignment";
			Class.forName("com.mysql.jdbc.Driver");
			conn1 = DriverManager.getConnection(URL, "root", "root");

			//Statement st = conn1.createStatement(); 
			Statement st = conn1.createStatement(); 
			ResultSet rs = st.executeQuery("select * from purchases");

			PurchasesBean ve = null;
			while (rs.next()) {
				ve = new PurchasesBean();
				ve.setPurchases_id(rs.getInt(1));
				ve.setTitle(rs.getString(2));
				ve.setManufacturer(rs.getString(3));
				ve.setPrice(rs.getFloat(4));
				ve.setAmmount(rs.getInt(5));

				purchasesList.add(ve);

//				Statement st1 = conn1.createStatement(); 
//				ResultSet rs1 = st1.executeQuery("select * from user where name ='session.user.getId()'");
//				User user = new User();
//				user.setName(rs1.getString(1));

				ret = SUCCESS;
			}

		} catch (Exception e) {
			ret = ERROR;
		} finally {
			if (conn1 != null) {
				try {
					conn1.close();
				} catch (Exception e) {
				}
			}
		}

		return ret;
	}

	public ArrayList<PurchasesBean> getPurchasesList() {
		return purchasesList;
	}

	public void setPurchasesList(ArrayList<PurchasesBean> purchasesList) {
		this.purchasesList = purchasesList;
	}


	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmmount() {
		return ammount;
	}

	public void setAmmount(int ammount) {
		this.ammount = ammount;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getPurchases_id() {
		return purchases_id;
	}

	public void setPurchases_id(int purchases_id) {
		this.purchases_id = purchases_id;
	}
}
