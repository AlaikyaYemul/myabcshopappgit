package com.abcshopapp.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

import com.abcshopapp.dto.Product;
import com.abcshopapp.util.DBUtil;

public class ProductInsertDemo {

	public static void main(String[] args) {

		LocalDate mfd = LocalDate.of(2022, Month.OCTOBER, 30);

		Product product = new Product();
		product.setProductName("IphoneZ");
		product.setProductPrice(125000.23);
		product.setCategory("Mobile");
		product.setMfd(LocalDate.of(2022, Month.OCTOBER, 30));

		String sql = "insert into product_tbl(product_name,product_price,mfd,category) values(?,?,?,?)";

		try (
				Connection con = DBUtil.getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, product.getProductName());
			ps.setDouble(2, product.getProductPrice());
			Date sdate = Date.valueOf(product.getMfd());
			ps.setDate(3, sdate);
			ps.setString(4, product.getCategory());

			ps.executeUpdate();
			System.out.println("New product added.");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
