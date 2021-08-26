package com.weatherApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.weatherApp.model.ForecastWeather;
import com.weatherApp.service.ForecastWeatherSerice;

@RestController
public class ForecastWeatherController {

	@Autowired
	private ForecastWeatherSerice forecastWeatherSerice;

	@GetMapping("/forecastWeather")
	public ModelAndView getForecastWeatherView() throws Exception {
		ModelAndView mav = new ModelAndView("forecast.html");
		mav.addObject("showWeather", false);
		return mav;
	}

	@PostMapping("/forecastWeather")
	public ModelAndView getForecastWeatherData(@RequestParam(value = "cityName", required = false) String cityName,
			@RequestParam(value= "onlyToday", required = false) boolean onlyToday)
			throws Exception {
		ModelAndView mav = new ModelAndView("forecast.html");
		try {
			if (cityName.trim() == "" || cityName.trim() == null) {
				mav.addObject("error", "Field Cannot be Empty");
				mav.addObject("showWeather", false);
				return mav;
			}
			
			ForecastWeather forecastWeather = forecastWeatherSerice.getForecastWeather(cityName, onlyToday);
			if (forecastWeather == null) {
				mav.addObject("error", "Invalid City Name / State Code");
				mav.addObject("showWeather", false);
				return mav;
			} else {
				mav.addObject("forecastWeather", forecastWeather);
				mav.addObject("showWeather", true);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	

}
