package com.jeejava.service;

import org.springframework.stereotype.Service;

@Service
public class TemperatureService {
	public double convertCelsiusToFahrenheit(final double celsius) {
		double fahrenheit = (9.0 / 5.0) * celsius + 32;
		return fahrenheit;
	}
}