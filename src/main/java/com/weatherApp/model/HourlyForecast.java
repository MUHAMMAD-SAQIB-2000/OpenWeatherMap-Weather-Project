package com.weatherApp.model;

import java.util.List;

public class HourlyForecast {

	private String cityName;
	private String countryName;

	private Double longitude;
	private Double latitude;
	private List<HourlyForecastDetails> hourlyForecastDetails;

	public HourlyForecast() {
	}

	@Override
	public String toString() {
		return "HourlyForecast [cityName=" + cityName + ", countryName=" + countryName + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", hourlyForecastDetails=" + hourlyForecastDetails.toString() + "]";
	}

	public HourlyForecast(String cityName, String countryName, Double longitude, Double latitude,
			List<HourlyForecastDetails> hourlyForecastDetails) {
		this.cityName = cityName;
		this.countryName = countryName;
		this.longitude = longitude;
		this.latitude = latitude;
		this.hourlyForecastDetails = hourlyForecastDetails;
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

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public List<HourlyForecastDetails> getHourlyForecastDetails() {
		return hourlyForecastDetails;
	}

	public void setHourlyForecastDetails(List<HourlyForecastDetails> hourlyForecastDetails) {
		this.hourlyForecastDetails = hourlyForecastDetails;
	}

}
