package com.roytuts.spring.soap.header.authentication.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.roytuts.spring.soap.header.authentication.endpoint.Hello;

@Configuration
public class SpringSoapConfig {

	@Autowired
	private Bus bus;
	
	@Autowired
	private Hello hello;

	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, hello);
		endpoint.publish("/hello");
		return endpoint;
	}
	
	/*@Bean
	public Servlet servlet() {
		return new WSSpringServlet();
	}
	
	@Bean
	public ServletRegistrationBean<Servlet> servletRegistrationBean(){
		return new ServletRegistrationBean<Servlet>(servlet(), "/services/*");
	}
	
	@Bean()
	public SpringBinding springBinding() throws Exception {
		SpringService service=new SpringService();
		service.setBean(hello);
		SpringBinding binding=new SpringBinding();
		binding.setService(service.getObject());
		binding.setUrl("/services/hello");
		return binding;
	}*/

}
