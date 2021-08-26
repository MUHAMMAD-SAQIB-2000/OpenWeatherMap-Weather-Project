package com.weatherApp.model;

public class WeatherDetails {
	
	private String celsiusTemp;
	private String fehrenhiteTemp;
	private String tempFeelsLike;
	private String pressure;
	private String humidity;
	private Double longitude;
	private Double latitude;
	
	public WeatherDetails() {}
	
	public WeatherDetails(String celsiusTemp, String fehrenhiteTemp, String tempFeelsLike, String pressure,
			String humidity, Double longitude, Double latitude) {
		this.celsiusTemp = celsiusTemp;
		this.fehrenhiteTemp = fehrenhiteTemp;
		this.tempFeelsLike = tempFeelsLike;
		this.pressure = pressure;
		this.humidity = humidity;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "WeatherDetails [celciusTemp=" + celsiusTemp + ", fehrenhiteTemp=" + fehrenhiteTemp + ", tempFeelsLike="
				+ tempFeelsLike + ", pressure=" + pressure + ", humidity=" + humidity + ", longitude=" + longitude
				+ ", latitude=" + latitude + "]";
	}

	public String getCelsiusTemp() {
		return celsiusTemp;
	}

	public void setCelciusTemp(String celsiusTemp) {
		this.celsiusTemp = celsiusTemp;
	}

	public String getFehrenhiteTemp() {
		return fehrenhiteTemp;
	}

	public void setFehrenhiteTemp(String fehrenhiteTemp) {
		this.fehrenhiteTemp = fehrenhiteTemp;
	}

	public String getTempFeelsLike() {
		return tempFeelsLike;
	}

	public void setTempFeelsLike(String tempFeelsLike) {
		this.tempFeelsLike = tempFeelsLike;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
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

}
