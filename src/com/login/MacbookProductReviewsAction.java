package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;

public class MacbookProductReviewsAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<ProductReview> reviewList;
	
	public MacbookProductReviewsAction() {
		
	}
	
	public String execute() {
		
		String ret = ERROR;
	      Connection con = null;
	      reviewList  =  new ArrayList<ProductReview>();

	      try {
	        
	    	  String URL = "jdbc:mysql://localhost/paddyassignment";
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(URL, "root", "root");
				
				Statement st = con.createStatement(); 
				ResultSet rs = st.executeQuery("select * from productreviews where product = 'Macbook Pro'");
				
				ProductReview review = null;
				 while (rs.next()) {
					 review = new ProductReview();
					 review.setName(rs.getString(1));
					 review.setProduct(rs.getString(2));
					 review.setComment(rs.getString(3));
					 review.setRating(rs.getInt(4));
					 review.setDate(rs.getTimestamp(5));
	
					reviewList.add(review);
					
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

	public ArrayList<ProductReview> getReviewList() {
		return reviewList;
	}

	public void setReviewList(ArrayList<ProductReview> reviewList) {
		this.reviewList = reviewList;
	}
}

	
