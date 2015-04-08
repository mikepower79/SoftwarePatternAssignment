package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateDatabaseAction extends ActionSupport{

	
	private static final long serialVersionUID = -453350948722456448L;
	private String title ;
	private String manufacturer,time;
	private int quantity,purchases_id,item_id;
	private float price;
	
	public String execute() {
		String ret = ERROR;
		Connection conn1 = null;
		
		try {
			String URL = "jdbc:mysql://localhost/paddy";
			Class.forName("com.mysql.jdbc.Driver");
		
			conn1 = DriverManager.getConnection(URL, "root", "root");
			
			Statement st1 = conn1.createStatement(); 
			ResultSet rs1 = st1.executeQuery("select * from purchases");
			
			PreparedStatement ps2=conn1.prepareStatement("Delete from purchases where purchases_id >= 0");
			ps2.executeUpdate();
			
			PreparedStatement ps=conn1.prepareStatement("insert into history values(?,?,?,?,?,?,?)");
			while (rs1.next()) {
			ps.setInt(1, getItem_id());
			ps.setInt(2, rs1.getInt(1));
			ps.setString(3,rs1.getString(2));
			ps.setString(4,rs1.getString(3));			  			
			ps.setFloat(5,rs1.getFloat(4));
			ps.setInt(6,rs1.getInt(5));
			ps.setString(7, getTime());
			ps.executeUpdate();
			
			}
			
			
			ret = SUCCESS;
			
	
	
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

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	

}
