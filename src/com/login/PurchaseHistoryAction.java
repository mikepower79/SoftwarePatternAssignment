package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseHistoryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ArrayList<PurchasedItem> purchasesList;
	
	public PurchaseHistoryAction() {
		
	}
	
	public String execute() {
		String ret = ERROR;
	      Connection con = null;
	      purchasesList  =  new ArrayList<PurchasedItem>();

	      try {
	        
	    	  String URL = "jdbc:mysql://localhost/paddyassignment";
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(URL, "root", "root");
				
				Statement st = con.createStatement(); 
				ResultSet rs = st.executeQuery("select * from purchases ");
				
				 PurchasedItem purchasedItem = null;
				 while (rs.next()) {
					 purchasedItem = new PurchasedItem();
					 purchasedItem.setTitle(rs.getString(2));
					 purchasedItem.setManufacturer(rs.getString(3));
					 purchasedItem.setPrice(rs.getFloat(4));
					 purchasedItem.setQuantity(rs.getInt(5));
					 
					 purchasesList.add(purchasedItem);
					
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

	public ArrayList<PurchasedItem> getPurchasesList() {
		return purchasesList;
	}

	public void setPurchasesList(ArrayList<PurchasedItem> purchasesList) {
		this.purchasesList = purchasesList;
	}
}
