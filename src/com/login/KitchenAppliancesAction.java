package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;

public class KitchenAppliancesAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Item> itemList;
	
	public String execute() {
	      String ret = ERROR;
	      Connection conn1 = null;
	      itemList  =  new ArrayList<Item>();

	      try {
	    	    String URL = "jdbc:mysql://localhost/paddyassignment";
				Class.forName("com.mysql.jdbc.Driver");
				conn1 = DriverManager.getConnection(URL, "root", "root");
				
				Statement st1 = conn1.createStatement(); 
				ResultSet rs1 = st1.executeQuery("select * from item where category = 'Kitchen Appliances' ");
				
			    Item ve = null;
			   
				while (rs1.next()) {
					  ve = new Item();
					
					ve.setItem_id(rs1.getInt(1));
					ve.setTitle(rs1.getString(2));
					ve.setManufacturer(rs1.getString(3));
					ve.setPrice(rs1.getFloat(4));
					ve.setCategory(rs1.getString(5));
					ve.setImage(rs1.getString(6));
					ve.setQuantity(rs1.getInt(7));
					itemList.add(ve);
					
					}

				return SUCCESS;
	      }
			 catch (Exception e) {
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

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList1) {
		this.itemList = itemList1;
	}
}