package com.abcshopapp.main;

import java.util.Scanner;

import com.abcshopapp.dto.Product;
import com.abcshopapp.service.ProductService;
import com.abcshopapp.service.ProductServiceImpl;

public class InsertProductMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter productName: ");
		String productName = sc.next();
		
		System.out.println("Enter productPrice: ");
		double productPrice = sc.nextDouble();

		System.out.println("Enter MFD: ");
		String mfd = sc.next();
		
		System.out.println("Enter category: ");
		String category = sc.next();

		sc.close();
		
		Product product = new Product();
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		product.setMfd(null);
		product.setCategory(category);
		
		
		ProductService productService = new ProductServiceImpl();
		productService.addProduct(product);

	}

}
