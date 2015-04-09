package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;

public class ProductReviewsAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<ProductReview>  reviewList;
	
	public ProductReviewsAction() {
	}

	public String execute() {
		
		String ret = ERROR;
	      Connection conn1 = null;
	      reviewList  =  new ArrayList<ProductReview>();

	      try {
	        
	    	  String URL = "jdbc:mysql://localhost/paddyassignment";
				Class.forName("com.mysql.jdbc.Driver");
				conn1 = DriverManager.getConnection(URL, "root", "root");
				
				Statement st1 = conn1.createStatement(); 
				ResultSet rs1 = st1.executeQuery("select * from productReviews");
				
				ProductReview ve = null;
				 while (rs1.next()) {
					ve = new ProductReview();
					ve.setManufacturer(rs1.getString(1));
					ve.setTitle(rs1.getString(2));
					ve.setImage(rs1.getString(3));
					ve.setComment(rs1.getString(4));
									
					reviewList.add(ve);
					
				}
				return SUCCESS;
				
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

	public ArrayList<ProductReview> getReviewList() {
		return reviewList;
	}

	public void setReviewList(ArrayList<ProductReview> reviewList) {
		this.reviewList = reviewList;
	}
}

	
