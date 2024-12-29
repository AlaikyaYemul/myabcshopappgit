package com.abcshopapp.dao;

import com.abcshopapp.dto.Customer;

public interface CustomerDao {
	
	Customer findById(int customerId);

}
