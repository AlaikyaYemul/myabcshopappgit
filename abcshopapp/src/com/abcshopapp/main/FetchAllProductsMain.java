package com.abcshopapp.main;

import java.util.List;

import com.abcshopapp.dto.Product;
import com.abcshopapp.service.ProductService;
import com.abcshopapp.service.ProductServiceImpl;

public class FetchAllProductsMain {

	public static void main(String[] args) {
		
		ProductService productService = new ProductServiceImpl();
		List<Product> products = productService.getAllProducts();
		
		System.out.println("------------------------------------");
		for(Product product : products) {
			System.out.println("Product Id : "+product.getProductId());
			System.out.println("Product Name : "+product.getProductName());
			System.out.println("Product Price : "+product.getProductPrice());
			System.out.println("MFD : "+product.getMfd());
			System.out.println("Category : "+product.getCategory());
			System.out.println("------------------------------------");
		}

	}

}
