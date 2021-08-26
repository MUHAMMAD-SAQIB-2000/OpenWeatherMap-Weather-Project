package com.weatherApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.weatherApp.service.HourlyForecastService;

@RestController
public class WeatherAppController {
	
	@Autowired
	private HourlyForecastService hourlyForecastService;
	
	@GetMapping("/")
	public ModelAndView hardCodedWeatherData() throws Exception {
		return new ModelAndView("index.html");
	}
	
	@GetMapping("/test")
	public ModelAndView testAPI() throws Exception {
		hourlyForecastService.getHourlyWeather("gujrat", false);
		return new ModelAndView("index.html");
	}
}
