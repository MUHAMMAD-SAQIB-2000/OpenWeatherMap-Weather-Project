package com.weatherApp.model;

public class CurrentWeather {

	private Weather weather;
	private WeatherDetails weatherDetails;
	private String weatherDateTime;

	public CurrentWeather(Weather weather, WeatherDetails weatherDetails, String weatherDateTime) {
		super();
		this.weather = weather;
		this.weatherDetails = weatherDetails;
		this.weatherDateTime = weatherDateTime;
	}

	public CurrentWeather() {
	}

	@Override
	public String toString() {
		return "CurrentWeather [weather=" + weather.toString() + ", weatherDetails=" + weatherDetails.toString() + ", weatherDateTime="
				+ weatherDateTime + "]";
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	public WeatherDetails getWeatherDetails() {
		return weatherDetails;
	}

	public void setWeatherDetails(WeatherDetails weatherDetails) {
		this.weatherDetails = weatherDetails;
	}

	public String getWeatherDateTime() {
		return weatherDateTime;
	}

	public void setWeatherDateTime(String weatherDateTime) {
		this.weatherDateTime = weatherDateTime;
	}

}
