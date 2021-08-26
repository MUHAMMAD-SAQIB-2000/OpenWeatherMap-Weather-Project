package com.weatherApp.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weatherApp.model.CurrentWeather;
import com.weatherApp.model.Weather;
import com.weatherApp.model.WeatherDetails;

@Service
public class CurrentWeatherService {

	@Autowired
	private WeatherAppService weatherAppService;

	private JSONObject jsonResponseObject;

	public CurrentWeather getCurrentWeather(String name) throws Exception {
		jsonResponseObject = weatherAppService.getWeatherAPIData(getAPI(name));	

		CurrentWeather currentWeather = new CurrentWeather();
		
		if (jsonResponseObject == null) {
			return null;
		} else {
			Weather weather = getWeatherForCurrentWeather(jsonResponseObject);
			WeatherDetails weatherDetails = getWeatherDetailsForCurrentWeather(jsonResponseObject);
			
			currentWeather.setWeather(weather);
			currentWeather.setWeatherDetails(weatherDetails);
			currentWeather.setWeatherDateTime(convertToLocalTime(jsonResponseObject.getLong("dt")));
		}

		return currentWeather;
	}

	private String getAPI(String name) {
		return "https://api.openweathermap.org/data/2.5/weather?q=" + name
				+ "&units=metric&APPID=e4961a86c1756902cecfd5cedf8215e7";
	}
	
	private Weather getWeatherForCurrentWeather(JSONObject jsonResponseObject) throws Exception {
		Weather weather = new Weather();
		weather.setCityName(jsonResponseObject.getString("name"));
		weather.setCountryName(jsonResponseObject.getJSONObject("sys").getString("country"));

		JSONArray returnWeatherArray = jsonResponseObject.getJSONArray("weather");
		weather.setWeatherMain(returnWeatherArray.getJSONObject(0).getString("main"));
		weather.setWeatherDesc(returnWeatherArray.getJSONObject(0).getString("description"));
//		String icon = "http://openweathermap.org/img/wn/" + returnWeatherArray.getJSONObject(0).getString("icon")
//				+ ".png";

//		weather.setWeatherIcon(icon);
		weather.setWeatherIcon(returnWeatherArray.getJSONObject(0).getString("icon")+ ".png");
		weather.setWeatherResponseMessage("Enjoy Your Day :)");

		return weather;
	}
	
	private WeatherDetails getWeatherDetailsForCurrentWeather(JSONObject jsonResponseObject) throws Exception {
		WeatherDetails weatherDetails = new WeatherDetails();
		
		weatherDetails.setLongitude(jsonResponseObject.getJSONObject("coord").getDouble("lon"));
		weatherDetails.setLatitude(jsonResponseObject.getJSONObject("coord").getDouble("lat"));
		
		Double celcTemp = Math.floor(jsonResponseObject.getJSONObject("main").getDouble("temp"));
		Double fehTemp = (9.0/5.0)*celcTemp + 32;
		weatherDetails.setCelciusTemp(celcTemp.intValue()+""+'\u2032'+" C");
		weatherDetails.setFehrenhiteTemp(fehTemp.intValue()+""+'\u2032'+" F");
		
		Double feelsLike = jsonResponseObject.getJSONObject("main").getDouble("feels_like");
		weatherDetails.setTempFeelsLike(feelsLike.intValue()+""+'\u2032'+" C");
		weatherDetails.setPressure(jsonResponseObject.getJSONObject("main").getInt("pressure")+" hPa");
		weatherDetails.setHumidity(jsonResponseObject.getJSONObject("main").getInt("humidity")+"%");
		
		return weatherDetails;
	}
	
	private String convertToLocalTime(long unixSeconds) {
		Date localDate = new Date(unixSeconds * 1000L);
		SimpleDateFormat sdf = new SimpleDateFormat("EEE d MM, HH:mm z");
		return sdf.format(localDate);
	}
	
	public CurrentWeather getDummyCurrentWeather() {
		WeatherDetails dummyWeatherDetails = new WeatherDetails("N/A", "N/A", "N/A", "N/A", "N/A", 0.0, 0.0);
		String icon = "http://openweathermap.org/img/wn/01n.png";
		Weather dummyWeather = new Weather("N/A", "N/A", "N/A", "N/A", icon,"Invalid City/State Name/Code");
		return new CurrentWeather(dummyWeather, dummyWeatherDetails, "");
	}
	
	

}
