package com.weatherApp.model;

public class HourlyForecastDetails {

	private String weatherMain;
	private String weatherDesc;
	private String weatherIcon;
	private String hourlyCelsiusTemp;
	private String hourlyFehrenhiteTemp;
	private String hourlyTempFeelsLike;
	private String hourlyPressure;
	private String hourlyHumidity;
	private String hourlyHourTime;

	public HourlyForecastDetails() {
	}

	public HourlyForecastDetails(String weatherMain, String weatherDesc, String weatherIcon, String hourlyCelsiusTemp,
			String hourlyFehrenhiteTemp, String hourlyTempFeelsLike, String hourlyPressure, String hourlyHumidity,
			String hourlyHourTime) {
		this.weatherMain = weatherMain;
		this.weatherDesc = weatherDesc;
		this.weatherIcon = weatherIcon;
		this.hourlyCelsiusTemp = hourlyCelsiusTemp;
		this.hourlyFehrenhiteTemp = hourlyFehrenhiteTemp;
		this.hourlyTempFeelsLike = hourlyTempFeelsLike;
		this.hourlyPressure = hourlyPressure;
		this.hourlyHumidity = hourlyHumidity;
		this.hourlyHourTime = hourlyHourTime;
	}

	@Override
	public String toString() {
		return "HourlyForecastDetails [weatherMain=" + weatherMain + ", weatherDesc=" + weatherDesc + ", weatherIcon="
				+ weatherIcon + ", hourlyCelsiusTemp=" + hourlyCelsiusTemp + ", hourlyFehrenhiteTemp="
				+ hourlyFehrenhiteTemp + ", hourlyTempFeelsLike=" + hourlyTempFeelsLike + ", hourlyPressure="
				+ hourlyPressure + ", hourlyHumidity=" + hourlyHumidity + ", hourlyHourTime=" + hourlyHourTime + "]";
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

	public String getHourlyCelsiusTemp() {
		return hourlyCelsiusTemp;
	}

	public void setHourlyCelsiusTemp(String hourlyCelsiusTemp) {
		this.hourlyCelsiusTemp = hourlyCelsiusTemp;
	}

	public String getHourlyFehrenhiteTemp() {
		return hourlyFehrenhiteTemp;
	}

	public void setHourlyFehrenhiteTemp(String hourlyFehrenhiteTemp) {
		this.hourlyFehrenhiteTemp = hourlyFehrenhiteTemp;
	}

	public String getHourlyTempFeelsLike() {
		return hourlyTempFeelsLike;
	}

	public void setHourlyTempFeelsLike(String hourlyTempFeelsLike) {
		this.hourlyTempFeelsLike = hourlyTempFeelsLike;
	}

	public String getHourlyPressure() {
		return hourlyPressure;
	}

	public void setHourlyPressure(String hourlyPressure) {
		this.hourlyPressure = hourlyPressure;
	}

	public String getHourlyHumidity() {
		return hourlyHumidity;
	}

	public void setHourlyHumidity(String hourlyHumidity) {
		this.hourlyHumidity = hourlyHumidity;
	}

	public String getHourlyHourTime() {
		return hourlyHourTime;
	}

	public void setHourlyHourTime(String hourlyHourTime) {
		this.hourlyHourTime = hourlyHourTime;
	}

}
