package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class AddToBasket extends ActionSupport{
	
	ArrayList<Item> itemList;
	ArrayList<PurchasesBean> purchasesList;
	private static final long serialVersionUID = 1L;
	private String email,title,manufacturer,category;
	private int purchases_id, item_id,id,ammount,quantity;
	private float price;
	private int num;
	
	public String execute() {
		
		String ret = ERROR;
		Connection conn = null;
		itemList =  new ArrayList<Item>();
		purchasesList = new ArrayList<PurchasesBean>();

		try {
			String URL = "jdbc:mysql://localhost/paddyassignment";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "root");
	
			num =getId();
			System.out.println(num+"bbbbbbbbbbbbbbb");
			
			Statement st = conn.createStatement(); 
			ResultSet rs = st.executeQuery("select * from item where item_id = 5 ");
		       
			Item ve = null;
			while (rs.next()) {
				ve = new Item();
				ve.setItem_id(rs.getInt(1));
				ve.setTitle(rs.getString(2));
				ve.setManufacturer(rs.getString(3));
				ve.setPrice(rs.getFloat(4));
				
				itemList.add(ve);
				
				PreparedStatement ps=conn.prepareStatement("insert into purchases values(?,?,?,?,?)"); 
				ps.setInt(1, getPurchases_id());
				ps.setString(2, rs.getString(2));				
				ps.setString(3 , rs.getString(3));
				ps.setFloat(4 , rs.getFloat(4));
				ps.setInt(5 , getAmmount());
				
				ps.executeUpdate();
				
				PurchasesBean purchases =  new PurchasesBean();
				purchases.setTitle(rs.getString(2));
				purchases.setManufacturer(rs.getString(3));
				purchases.setPrice(rs.getFloat(4));
				purchases.setAmmount(getAmmount());
				purchasesList.add(purchases);
				
				ret = SUCCESS;
		
			}
		} catch (Exception e) {
			ret = ERROR;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		}
	
		return ret;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public ArrayList<PurchasesBean> getPurchasesList() {
		return purchasesList;
	}

	public void setPurchasesList(ArrayList<PurchasesBean> purchasesList) {
		this.purchasesList = purchasesList;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	private int getItem_id() {
		// TODO Auto-generated method stub
		return item_id;
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
