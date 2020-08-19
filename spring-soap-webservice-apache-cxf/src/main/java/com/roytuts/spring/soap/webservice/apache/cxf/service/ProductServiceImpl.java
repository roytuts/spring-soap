package com.roytuts.spring.soap.webservice.apache.cxf.service;

import java.util.List;

import javax.jws.WebService;

import com.roytuts.spring.soap.webservice.apache.cxf.dao.ProductDao;
import com.roytuts.spring.soap.webservice.apache.cxf.dto.Product;

@WebService(endpointInterface = "com.roytuts.spring.soap.webservice.apache.cxf.service.ProductService", serviceName = "productService")
public class ProductServiceImpl implements ProductService {

	private ProductDao dao;

	public ProductServiceImpl() {
		dao = new ProductDao();
	}

	@Override
	public List<Product> getAllProducts() {
		return dao.getAllProducts();
	}

	@Override
	public Product getProduct(int productId) {
		return dao.getProduct(productId);
	}

}
