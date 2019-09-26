package com.roytuts.spring.soap.https.client.certificate.authentication.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.roytuts.jaxb.GetCelsiusRequest;
import com.roytuts.jaxb.GetCelsiusResponse;
import com.roytuts.spring.soap.https.client.certificate.authentication.service.TemperatureService;

@Endpoint
public class TemperatureServiceEndpoint {

	private final String NAMESPACE = "http://www.example.com/TemperatureService";

	@Autowired
	TemperatureService temperatureService;

	@ResponsePayload
	@PayloadRoot(namespace = NAMESPACE, localPart = "GetCelsiusRequest")
	public GetCelsiusResponse getFahrenheit(@RequestPayload final GetCelsiusRequest input) {
		GetCelsiusResponse response = new GetCelsiusResponse();
		response.setFahrenheit(temperatureService.convertCelsiusToFahrenheit(input.getCelcius()));
		return response;
	}

}
