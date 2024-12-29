package com.abcshopapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abcshopapp.dto.Customer;
import com.abcshopapp.util.DBUtil;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public Customer findById(int customerId) {
		String sql = "select * from customer_tbl where customer_id = ?";
		Customer customer = new Customer();
		try(
				Connection con = DBUtil.getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			
			ps.setInt(1, customerId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int custId = rs.getInt(1);
				String custName = rs.getString(2);
				String city = rs.getString(3);
				String email = rs.getString(4);
				
				customer.setCustomerId(custId);
				customer.setCustomerName(custName);
				customer.setCity(city);
				customer.setEmail(email);
				
			}
			
		}
		catch(SQLException e) {
			e.getStackTrace();
		}
		return customer;
	}

}
