package com.abcshopapp.service;

import java.util.List;

import com.abcshopapp.dao.CustomerDao;
import com.abcshopapp.dao.CustomerDaoImpl;
import com.abcshopapp.dao.ProductDao;
import com.abcshopapp.dao.ProductDaoImpl;
import com.abcshopapp.dto.Customer;
import com.abcshopapp.dto.Invoice;
import com.abcshopapp.dto.Product;

public class ProductServiceImpl implements ProductService {

	//	@Override
	//	public double calculateOrderAmount(int customerId, int productId, int quantity) {
	//
	//		//calling dao to get product details
	//		ProductDao productDao = new ProductDaoImpl();
	//
	//		Product product = productDao.findById(productId);
	//
	//		double totalPrice = product.getProductPrice() * quantity;
	//
	//		double orderAmount = totalPrice + (totalPrice * 0.05);
	//
	//		return orderAmount;
	//		
	//		//TO-DO
	//		// return Invoice
	//	}

	@Override
	public Invoice calculateOrderAmount(int customerId, int productId, int quantity) {
		ProductDao productDao = new ProductDaoImpl();

		Product product = productDao.findById(productId);
		
		CustomerDao customerDao = new CustomerDaoImpl();
		
		Customer customer = customerDao.findById(customerId);

		double totalPrice = product.getProductPrice() * quantity;
		
		double gst = totalPrice*0.05;

		double orderAmount = totalPrice + gst;
		
		Invoice invoice = new Invoice();
		String invoiceNumber = Integer.toString(customerId)+Integer.toString(productId);
		int invoiceNo = Integer.valueOf(invoiceNumber).intValue();
		
		invoice.setInvoiceNo(invoiceNo);
		invoice.setProductName(product.getProductName());
		invoice.setUnitPrice(product.getProductPrice());
		invoice.setCustomerName(customer.getCustomerName());
		invoice.setEmail(customer.getEmail());
		invoice.setQuantity(quantity);
		invoice.setTotalCost(totalPrice);
		invoice.setGst(gst);
		invoice.setOrderAmount(orderAmount);		
		
		return invoice;
	}

	@Override
	public void addProduct(Product product) {
		ProductDao productDao = new ProductDaoImpl();
		productDao.save(product);
		
	}

	@Override
	public List<Product> getAllProducts() {
		ProductDao productDao = new ProductDaoImpl();
		List<Product> products = productDao.findAll();
		return products;
	}

}
