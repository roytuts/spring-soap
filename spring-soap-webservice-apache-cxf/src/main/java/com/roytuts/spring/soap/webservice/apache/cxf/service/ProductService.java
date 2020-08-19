package com.roytuts.spring.soap.webservice.apache.cxf.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.roytuts.spring.soap.webservice.apache.cxf.dto.Product;

@WebService
public interface ProductService {

	@WebMethod
	public List<Product> getAllProducts();

	@WebMethod
	public Product getProduct(@WebParam(name = "productId") int productId);

}
