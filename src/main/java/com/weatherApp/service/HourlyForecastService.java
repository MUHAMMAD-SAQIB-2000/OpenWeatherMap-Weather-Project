package com.weatherApp.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weatherApp.model.HourlyForecast;
import com.weatherApp.model.HourlyForecastDetails;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class HourlyForecastService {

	@Autowired
	private WeatherAppService weatherAppService;

	private OkHttpClient client;
	private Response response;
	private JSONObject jsonResponseObject;

	public HourlyForecast getHourlyWeather(String cityName, boolean onlyToday) throws Exception {
		JSONObject cityNameJSONResponse = weatherAppService.getWeatherAPIData(getCityNameAPI(cityName));
		HourlyForecast hourlyForecast = new HourlyForecast();

		if (cityNameJSONResponse == null) {
			System.out.println("errored data!!!!");
			return null;
		} else {
			String countryName = cityNameJSONResponse.getJSONObject("sys").getString("country");
			JSONObject coordObject = cityNameJSONResponse.getJSONObject("coord");
			Double longitude = coordObject.getDouble("lon");
			Double latitude = coordObject.getDouble("lat");
			jsonResponseObject = getWeatherAPIData(longitude, latitude);

			hourlyForecast.setCityName(cityName);
			hourlyForecast.setCountryName(countryName);
			hourlyForecast.setLongitude(longitude);
			hourlyForecast.setLatitude(latitude);

			JSONArray hourly = jsonResponseObject.getJSONArray("hourly");
			List<HourlyForecastDetails> hourlyForecastDetailsList = new ArrayList<>();
			for (int i = 0; i < hourly.length(); i++) {
				HourlyForecastDetails hourlyForecastDetails = new HourlyForecastDetails();
				JSONObject hourlyObject = hourly.getJSONObject(i);
				
				Date date = new Date(hourlyObject.getLong("dt") * 1000L);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String todayDate = sdf.format(date);
				
				String localDate = LocalDate.now().toString();
				
				if(onlyToday) {
					if(todayDate.equals(localDate)) {
						hourlyForecastDetails = getHourlyForecastDetails(hourlyObject);											
					} else {
						return hourlyForecast;
					}
				} else {
					hourlyForecastDetails = getHourlyForecastDetails(hourlyObject);
				}
				hourlyForecastDetailsList.add(hourlyForecastDetails);
				hourlyForecast.setHourlyForecastDetails(hourlyForecastDetailsList);
			}
		}
		return hourlyForecast;

	}

	public HourlyForecastDetails getHourlyForecastDetails(JSONObject hourlyObject) throws Exception {
		HourlyForecastDetails hourlyForecastDetails = new HourlyForecastDetails();

		Double celcTemp = hourlyObject.getDouble("temp");
		Double fehTemp = (9.0 / 5.0) * celcTemp + 32;
		hourlyForecastDetails.setHourlyCelsiusTemp(celcTemp.intValue()+" "+'\u2032' + " C");
		hourlyForecastDetails.setHourlyFehrenhiteTemp(fehTemp.intValue()+" "+'\u2032' + " F");
		Double feelsLike = hourlyObject.getDouble("feels_like");
		hourlyForecastDetails.setHourlyTempFeelsLike(feelsLike.intValue()+" "+'\u2032' + " C");

		hourlyForecastDetails.setHourlyPressure(hourlyObject.getInt("pressure")+" hPa");
		hourlyForecastDetails.setHourlyHumidity(hourlyObject.getInt("humidity")+"%");
		hourlyForecastDetails.setHourlyHourTime(convertToLocalTime(hourlyObject.getLong("dt")));

		JSONObject weather = hourlyObject.getJSONArray("weather").getJSONObject(0);
		hourlyForecastDetails.setWeatherMain(weather.getString("main"));
		hourlyForecastDetails.setWeatherDesc(weather.getString("description"));
//		String icon = "http://openweathermap.org/img/wn/" + weather.getString("icon") + ".png";
		String icon = weather.getString("icon") + ".png";
		hourlyForecastDetails.setWeatherIcon(icon);

		return hourlyForecastDetails;

	}

	private String convertToLocalTime(long unixSeconds) {
		Date localDate = new Date(unixSeconds * 1000L);
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM \nHH:mm ");
		return sdf.format(localDate);
	}

	public JSONObject getWeatherAPIData(Double longitude, Double latitude) throws Exception {
		client = new OkHttpClient();
		Request request = new Request.Builder().url(getAPI(longitude, latitude)).build();
		response = client.newCall(request).execute();
		return new JSONObject(response.body().string());
	}

	private String getAPI(Double longitude, Double latitude) {
		return "https://api.openweathermap.org/data/2.5/onecall?lat=" + latitude + "&lon=" + longitude
				+ "&units=metric&exclude=current,minutely,daily,alerts&cnt=8&appid=e4961a86c1756902cecfd5cedf8215e7";
	}

	private String getCityNameAPI(String name) {
		return "https://api.openweathermap.org/data/2.5/weather?q=" + name
				+ "&units=metric&APPID=e4961a86c1756902cecfd5cedf8215e7";
	}

}
