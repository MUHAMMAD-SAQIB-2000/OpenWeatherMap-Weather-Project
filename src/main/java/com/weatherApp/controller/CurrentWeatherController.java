package com.weatherApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.weatherApp.model.CurrentWeather;
import com.weatherApp.service.CurrentWeatherService;

@RestController
public class CurrentWeatherController {

	@Autowired
	private CurrentWeatherService currentWeatherService;

	@GetMapping("/currentWeather")
	public ModelAndView getCurrentWeatherView() throws Exception {
		ModelAndView mav = new ModelAndView("current.html");
		mav.addObject("showWeather", false);
		return mav;
	}

	@PostMapping("/currentWeather")
	public ModelAndView getCurrentWeatherData(@RequestParam(value = "cityName", required = false) String cityName)
			throws Exception {
		ModelAndView mav = new ModelAndView("current.html");
		try {
			if (cityName.trim() == "" || cityName.trim() == null) {
				mav.addObject("error", "Field Cannot be Empty");
				mav.addObject("showWeather", false);
				return mav;
			}
			
			CurrentWeather currentWeather = currentWeatherService.getCurrentWeather(cityName);
			if (currentWeather == null) {
				mav.addObject("error", "Invalid City Name / State Code");
				mav.addObject("showWeather", false);
				return mav;
			} else {
				mav.addObject("currentWeather", currentWeather);
				mav.addObject("showWeather", true);				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
}
