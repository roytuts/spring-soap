package com.jeejava.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.jeejava.jaxb.GetCelsiusRequest;
import com.jeejava.jaxb.GetCelsiusResponse;
import com.jeejava.service.TemperatureService;

@Endpoint
public class TemperatureServiceEndpoint {
	final String NAMESPACE = "http://www.example.com/TemperatureService";

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
