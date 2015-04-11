package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ArrayList<User> customerList;
	
	public CustomerAction() {
		
	}
	
	public String execute() {
		String ret = ERROR;
	      Connection con = null;
	      customerList  =  new ArrayList<User>();

	      try {
	        
	    	  String URL = "jdbc:mysql://localhost/paddyassignment";
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(URL, "root", "root");
				
				Statement st = con.createStatement(); 
				ResultSet rs = st.executeQuery("select * from user ");
				
				 User user = null;
				 while (rs.next()) {
					 user = new User();
					 user.setName(rs.getString(2));
					 user.setAddress1(rs.getString(3));
					 user.setAddress2(rs.getString(4));
					 user.setAddress3(rs.getString(5));
					 user.setEmail(rs.getString(6));
					 
					 customerList.add(user);
					
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

	public ArrayList<User> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<User> customerList) {
		this.customerList = customerList;
	}
}
