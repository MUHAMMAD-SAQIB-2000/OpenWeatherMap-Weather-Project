package com.weatherApp.model;

public class Weather {
	
	private String cityName;
	private String countryName;
	private String weatherMain;
	private String weatherDesc;
	private String weatherIcon;
	private String weatherResponseMessage;
	
	@Override
	public String toString() {
		return "Weather [cityName=" + cityName + ", countryName=" + countryName + ", weatherMain=" + weatherMain
				+ ", weatherDesc=" + weatherDesc + ", weatherIcon=" + weatherIcon + ", weatherResponseMessage="
				+ weatherResponseMessage+ "]";
	}

	public Weather() {}

	public Weather(String cityName, String countryName, String weatherMain, String weatherDesc, String weatherIcon,
			String weatherResponseMessage) {
		this.cityName = cityName;
		this.countryName = countryName;
		this.weatherMain = weatherMain;
		this.weatherDesc = weatherDesc;
		this.weatherIcon = weatherIcon;
		this.weatherResponseMessage = weatherResponseMessage;
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
	
	public String getWeatherResponseMessage() {
		return weatherResponseMessage;
	}

	public void setWeatherResponseMessage(String weatherResponseMessage) {
		this.weatherResponseMessage = weatherResponseMessage;
	}

}
