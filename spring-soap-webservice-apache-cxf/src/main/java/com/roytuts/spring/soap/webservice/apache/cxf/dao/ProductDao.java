package com.roytuts.spring.soap.webservice.apache.cxf.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.roytuts.spring.soap.webservice.apache.cxf.dto.Product;

@Repository
public class ProductDao {

	List<Product> productList = new ArrayList<Product>();

	public ProductDao() {
		Product p1 = new Product(101, "Laptop", "Electronics");
		Product p2 = new Product(102, "Bannana", "Fruits");
		Product p3 = new Product(103, "Pencil", "Stationary");
		productList.add(p1);
		productList.add(p2);
		productList.add(p3);
	}

	public Product getProduct(int id) {
		for (Product product : productList) {
			if (product.getProductId() == id) {
				return product;
			}
		}
		return null;
	}

	public List<Product> getAllProducts() {
		return productList;
	}

}
