package com.weatherApp.model;

public class ForecastWeatherDetails {

	private String weatherMain;
	private String weatherDesc;
	private String weatherIcon;
	
	private WeatherDetails weatherDetails;
	
	private String forecastDataResponseTime;

	public ForecastWeatherDetails() {}
	
	public ForecastWeatherDetails(String weatherMain, String weatherDesc, String weatherIcon,
			WeatherDetails weatherDetails, String forecastDataResponseTime) {
		this.weatherMain = weatherMain;
		this.weatherDesc = weatherDesc;
		this.weatherIcon = weatherIcon;
		this.weatherDetails = weatherDetails;
		this.forecastDataResponseTime = forecastDataResponseTime;
	}

	@Override
	public String toString() {
		return "ForecastWeatherDetails [weatherMain=" + weatherMain + ", weatherDesc=" + weatherDesc + ", weatherIcon="
				+ weatherIcon + ", weatherDetails=" + weatherDetails.toString() + ", forecastDataResponseTime="
				+ forecastDataResponseTime + "]";
	}

	public String getWeatherMain() {
		return weatherMain;
	}

	public void setWeatherMain(String weatherMain) {
		this.weatherMain = weatherMain;
	}

	public String getWeatherDesc() {
		return weatherDesc;
	}

	public void setWeatherDesc(String weatherDesc) {
		this.weatherDesc = weatherDesc;
	}

	public String getWeatherIcon() {
		return weatherIcon;
	}

	public void setWeatherIcon(String weatherIcon) {
		this.weatherIcon = weatherIcon;
	}

	public WeatherDetails getWeatherDetails() {
		return weatherDetails;
	}

	public void setWeatherDetails(WeatherDetails weatherDetails) {
		this.weatherDetails = weatherDetails;
	}

	public String getForecastDataResponseTime() {
		return forecastDataResponseTime;
	}

	public void setForecastDataResponseTime(String forecastDataResponseTime) {
		this.forecastDataResponseTime = forecastDataResponseTime;
	}
	
}
