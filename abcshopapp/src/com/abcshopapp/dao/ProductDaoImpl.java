package com.abcshopapp.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import com.abcshopapp.dto.Product;
import com.abcshopapp.util.DBUtil;

public class ProductDaoImpl implements ProductDao {

	@Override
	public void save(Product product) {
		
		String sql = "insert into product_tbl(product_name,product_price,mfd,category) values(?,?,?,?)";
		
		try (Connection con = DBUtil.getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {

				ps.setString(1,product.getProductName());
				ps.setDouble(2,product.getProductPrice());
				ps.setDate(3,null);
				ps.setString(4,product.getCategory());
				
				ps.executeUpdate();

		}
		catch(SQLException e) {
			e.getStackTrace();
		}

	}

	@Override
	public Product findById(int productId) {
		
		String sql = "select * from product_tbl where product_id = ?";
		
		Product product = new Product();

		try (Connection con = DBUtil.getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, productId);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//get data from ResultSet
				int pId = rs.getInt(1);
				String productName = rs.getString(2);
				double productPrice = rs.getDouble(3);
				Date mfd = rs.getDate(4);
				String category = rs.getString(5);
				
				product.setProductId(pId);
				product.setProductName(productName);
				product.setProductPrice(productPrice);
				product.setMfd(null);
				product.setCategory(category);
				
			}

		}
		catch(SQLException e) {
			e.getStackTrace();
		}
		return product;
	}

	@Override
	public List<Product> findAll() {
		String sql = "select * from product_tbl";
		
		List<Product> products = new ArrayList<Product>();
		
		try(
				Connection con = DBUtil.getDBConnection();
				Statement st = con.createStatement();){
			
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int productId = rs.getInt(1);
				String productName = rs.getString(2);
				double productPrice = rs.getDouble(3);
				LocalDate date = null;
				if(rs.getDate(4)!=null) {
					date = rs.getDate(4).toLocalDate();
				}
				String category = rs.getString(5);
				
				Product product = new Product();
				product.setProductId(productId);
				product.setProductName(productName);
				product.setProductPrice(productPrice);
				product.setMfd(date);
				product.setCategory(category);
				
				products.add(product);
				
			}
			
		}
		catch(SQLException e) {
			e.getStackTrace();
		}
		
		return products;
	}



}
