package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

	public class IpadSelect extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String title;
	private ArrayList<Item> selectedList;
	ArrayList<PurchasesBean> purchasesList;
	private int purchases_id, quantity = 1;
	
	public String execute() {
		
		String ret = ERROR;
	      Connection con = null;
	      selectedList  =  new ArrayList<Item>();
	      purchasesList = new ArrayList<PurchasesBean>();

	      try {
	        
	    	  String URL = "jdbc:mysql://localhost/paddyassignment";
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(URL, "root", "root");
				
				Statement st = con.createStatement(); 
				ResultSet rs = st.executeQuery("select * from item where title = 'ipad'");
				
				Item item = null;
				 while (rs.next()) {
					 item = new Item();
					 item.setItem_id(rs.getInt(1));
					 item.setTitle(rs.getString(2));
					 item.setManufacturer(rs.getString(3));
					 item.setPrice(rs.getFloat(4));
					 item.setCategory(rs.getString(5));
					 item.setImage(rs.getString(6));
					 item.setQuantity(rs.getInt(7));
	
					 selectedList.add(item);
				 
					 PreparedStatement ps=con.prepareStatement("insert into purchases values(?,?,?,?,?)"); 
						ps.setInt(1, getPurchases_id());
						ps.setString(2, rs.getString(2));				
						ps.setString(3 , rs.getString(3));
						ps.setFloat(4 , rs.getFloat(4));
						ps.setInt(5 , getQuantity());
						
						ps.executeUpdate();
						
						PurchasesBean purchases =  new PurchasesBean();
						purchases.setTitle(rs.getString(2));
						purchases.setManufacturer(rs.getString(3));
						purchases.setPrice(rs.getFloat(4));
						purchases.setAmmount(getQuantity());
						purchasesList.add(purchases);
						
				}
				return SUCCESS;
				
			} catch (Exception e) {
				ret = ERROR;
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
					}
				}
			}
		
			return ret;
		}
	
	public ArrayList<Item> getSelectedList() {
		return selectedList;
	}
	
	public void setSelectedList(ArrayList<Item> selectedList) {
		this.selectedList = selectedList;
	}
	
	public ArrayList<PurchasesBean> getPurchasesList() {
		return purchasesList;
	}

	public void setPurchasesList(ArrayList<PurchasesBean> purchasesList) {
		this.purchasesList = purchasesList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPurchases_id() {
		return purchases_id;
	}

	public void setPurchases_id(int purchases_id) {
		this.purchases_id = purchases_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
