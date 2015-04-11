package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class AddProductReview extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String name, comment, product;
	private Timestamp date;
	private int rating;
           
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");                         
	public AddProductReview() {
		
	}
	
		public String execute() {
			String ret = ERROR;
			Connection con = null;
			
			try {
				String URL = "jdbc:mysql://localhost/paddyassignment";
				Class.forName("com.mysql.jdbc.Driver");
			
				con = DriverManager.getConnection(URL, "root", "root");
				
				PreparedStatement ps = con.prepareStatement("insert into productreviews values(?,?,?,?,?)");  
				ps.setString(1, getName());  
				ps.setString(2, getProduct());
				ps.setString(3, getComment());
				ps.setInt(4, getRating());
				ps.setTimestamp(5, getDate());
				
				ps.executeUpdate();
				
					ret = SUCCESS;
				
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
