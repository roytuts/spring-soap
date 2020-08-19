package com.roytuts.spring.soap.webservice.apache.cxf.config;

import javax.servlet.Servlet;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.roytuts.spring.soap.webservice.apache.cxf.service.ProductServiceImpl;

@Configuration
public class Config {

	@Autowired
	private Bus bus;

	@Bean
	public ServletRegistrationBean<Servlet> servletRegistrationBean(ApplicationContext context) {
		return new ServletRegistrationBean<Servlet>(new CXFServlet(), "/api/*");
	}

	@Bean
	public Endpoint productService() {
		EndpointImpl endpoint = new EndpointImpl(bus, new ProductServiceImpl());
		endpoint.publish("/productService");
		return endpoint;
	}

}
