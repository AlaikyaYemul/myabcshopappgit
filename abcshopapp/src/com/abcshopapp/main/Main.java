package com.abcshopapp.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.abcshopapp.util.DBUtil;

public class Main {

	public static void main(String[] args) {
		
		//presentation
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter customerId: ");
		int customerId = sc.nextInt();
		
		System.out.println("Enter productId: ");
		int pId = sc.nextInt();
		
		System.out.println("Enter Quantity: ");
		int quantity = sc.nextInt();
		
		sc.close();
		
		int productId = 0;
		String productName = null;
		double productPrice = 0;
		Date mfd = null;
		String category = null;
		
		//data access
		
		String sql = "select * from product_tbl where product_id = ?";
		
		try (Connection con = DBUtil.getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			
			ps.setInt(1, pId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				productId = rs.getInt(1);
				productName = rs.getString(2);
				productPrice = rs.getDouble(3);
				mfd = rs.getDate(4);
				category = rs.getString(5);
			}
			
		}
		catch(SQLException e) {
			e.getStackTrace();
		}
		
		//logic
		//calculate order amount = productPrice * quantity + gst
		double totalPrice = productPrice*quantity;
		
//		System.out.println("Total Price : "+totalPrice);
		
		double orderAmount = totalPrice + (totalPrice*0.05); // or orderAmount = 1.05*totalPrice
		
		//presentation
		System.out.println("Order Amount : "+orderAmount);
		

	}

}
