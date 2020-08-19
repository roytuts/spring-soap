package com.roytuts.spring.soap.webservice.apache.cxf.consumer;

import java.util.List;

import com.roytuts.spring.soap.webservice.apache.cxf.service.Product;
import com.roytuts.spring.soap.webservice.apache.cxf.service.ProductService;
import com.roytuts.spring.soap.webservice.apache.cxf.service.ProductService_Service;

public class ProductServiceConsumer {

	public static void main(String[] args) {
		ProductService productService = new ProductService_Service().getProductServiceImplPort();

		List<Product> products = productService.getAllProducts();

		products.forEach(p -> System.out.println(
				"Id: " + p.getProductId() + ", Name: " + p.getProductName() + ", Category: " + p.getProductCatg()));

		Product p = productService.getProduct(101);
		System.out.println("Producte for id 101: " + "Id: " + p.getProductId() + ", Name: " + p.getProductName()
				+ ", Category: " + p.getProductCatg());
	}

}
