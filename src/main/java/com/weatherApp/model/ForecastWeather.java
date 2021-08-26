package com.weatherApp.model;

import java.util.ArrayList;
import java.util.List;

public class ForecastWeather {

	private String cityName;
	private String countryName;
	private String weatherResponseMessage;
	
	private List<ForecastWeatherDetails> forecastWeatherDetails = new ArrayList<>();
	
	public ForecastWeather() {}

	public ForecastWeather(String cityName, String countryName, String weatherResponseMessage,
			List<ForecastWeatherDetails> forecastWeatherDetails) {
		this.cityName = cityName;
		this.countryName = countryName;
		this.weatherResponseMessage = weatherResponseMessage;
		this.forecastWeatherDetails = forecastWeatherDetails;
	}

	@Override
	public String toString() {
		return "ForecastWeather [cityName=" + cityName + ", countryName=" + countryName + ", weatherResponseMessage="
				+ weatherResponseMessage + ", forecastWeatherDetails=" + forecastWeatherDetails.toString() + "]";
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getWeatherResponseMessage() {
		return weatherResponseMessage;
	}

	public void setWeatherResponseMessage(String weatherResponseMessage) {
		this.weatherResponseMessage = weatherResponseMessage;
	}

	public List<ForecastWeatherDetails> getForecastWeatherDetails() {
		return forecastWeatherDetails;
	}

	public void setForecastWeatherDetails(List<ForecastWeatherDetails> forecastWeatherDetails) {
		this.forecastWeatherDetails = forecastWeatherDetails;
	}
	
}
