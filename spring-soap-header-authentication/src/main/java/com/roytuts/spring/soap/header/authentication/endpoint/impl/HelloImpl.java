package com.roytuts.spring.soap.header.authentication.endpoint.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.springframework.stereotype.Component;

import com.roytuts.spring.soap.header.authentication.endpoint.Hello;

@Component
@WebService(endpointInterface = "com.roytuts.spring.soap.header.authentication.endpoint.Hello")
public class HelloImpl implements Hello {

	@Resource
	WebServiceContext context;

	@Override
	public String sayHello(String name) {
		MessageContext messageContext = context.getMessageContext();

		/**
		 * get http header information
		 */
		Map<?, ?> httpHeaders = (Map<?, ?>) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
		List<?> users = (List<?>) httpHeaders.get("username");
		List<?> passwords = (List<?>) httpHeaders.get("password");

		/**
		 * retrieve username and password information from http headers
		 */
		String username = "";
		String password = "";

		if (users != null && !users.isEmpty()) {
			username = users.get(0).toString();
		}

		if (passwords != null && !passwords.isEmpty()) {
			password = passwords.get(0).toString();
		}

		/**
		 * verify the user and return response
		 */
		if (username.equalsIgnoreCase("user") && password.equals("pass")) {
			return "Hello, " + name;
		} else {
			return "Authentication faild! Please provide correct credentials";
		}
	}
}
