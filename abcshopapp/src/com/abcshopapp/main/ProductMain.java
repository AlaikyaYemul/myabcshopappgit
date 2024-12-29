package com.abcshopapp.main;

import java.util.Scanner;

import com.abcshopapp.dto.Invoice;
import com.abcshopapp.service.ProductService;
import com.abcshopapp.service.ProductServiceImpl;

public class ProductMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter customerId: ");
		int customerId = sc.nextInt();

		System.out.println("Enter productId: ");
		int pId = sc.nextInt();

		System.out.println("Enter Quantity: ");
		int quantity = sc.nextInt();

		sc.close();
		
		// calling service
		ProductService productService = new ProductServiceImpl();
//		double orderAmount = productService.calculateOrderAmount(customerId, pId, quantity);
		
//		System.out.println("Order Amount : "+orderAmount);
		
		Invoice invoice = productService.calculateOrderAmount(customerId, pId, quantity);
		
		System.out.println("\n------------INVOICE------------\n");
		System.out.println("Invoice Number : "+invoice.getInvoiceNo());
		System.out.println("Product Name : "+invoice.getProductName());
		System.out.println("Unit Price : "+invoice.getUnitPrice());
		System.out.println("Customer Name : "+invoice.getCustomerName());
		System.out.println("Email : "+invoice.getEmail());
		System.out.println("Quantity : "+invoice.getQuantity());
		System.out.println("Total Cost : "+invoice.getTotalCost());
		System.out.println("GST : "+invoice.getGst());
		System.out.println("Order Amount : "+invoice.getOrderAmount());
		System.out.println("\n--------------------------------");

	}

}
