package com.weatherApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.weatherApp.model.HourlyForecast;
import com.weatherApp.service.HourlyForecastService;

@RestController
public class HourlyForecastController {

	@Autowired
	private HourlyForecastService hourlyForecastService;

	@GetMapping("/hourlyForecast")
	public ModelAndView getCurrentWeatherView() throws Exception {
		ModelAndView mav = new ModelAndView("hourly.html");
		mav.addObject("showWeather", false);
		return mav;
	}

	@PostMapping("/hourlyForecast")
	public ModelAndView getCurrentWeatherData(@RequestParam(value = "cityName", required = false) String cityName,
			boolean onlyToday) throws Exception {
		ModelAndView mav = new ModelAndView("hourly.html");
		try {
			if (cityName.trim() == "" || cityName.trim() == null) {
				mav.addObject("error", "Field Cannot be Empty");
				mav.addObject("showWeather", false);
				return mav;
			}

			HourlyForecast hourlyForecast = hourlyForecastService.getHourlyWeather(cityName, onlyToday);
			if (hourlyForecast == null) {
				mav.addObject("error", "Invalid City Name / State Code");
				mav.addObject("showWeather", false);
				return mav;
			} else {
				mav.addObject("hourlyForecast", hourlyForecast);
				mav.addObject("showWeather", true);
//				System.out.println("Hourly: " + hourlyForecast.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

}
