package com.weatherApp.service;

//import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weatherApp.model.ForecastWeather;
import com.weatherApp.model.ForecastWeatherDetails;
import com.weatherApp.model.WeatherDetails;

@Service
public class ForecastWeatherSerice {

	@Autowired
	private WeatherAppService weatherAppService;

	private JSONObject jsonResponseObject;

	public ForecastWeather getForecastWeather(String name, boolean onlyToday) throws Exception {

		jsonResponseObject = weatherAppService.getWeatherAPIData(getAPI(name));
		ForecastWeather forecastWeather = new ForecastWeather();

		if (jsonResponseObject == null) {
			return null;
		} else {

			forecastWeather.setCityName(jsonResponseObject.getJSONObject("city").getString("name"));
			forecastWeather.setCountryName(jsonResponseObject.getJSONObject("city").getString("country"));
			forecastWeather.setWeatherResponseMessage(Integer.toString(jsonResponseObject.getInt("message")));

			List<ForecastWeatherDetails> forecastWeatherDetailsList = new ArrayList<>();
			JSONArray array = jsonResponseObject.getJSONArray("list");

			for (int i = 0; i < array.length(); i++) {
				ForecastWeatherDetails forecastWeatherDetails = new ForecastWeatherDetails();
				JSONObject object = array.getJSONObject(i);

//				String dataResponseTime = object.getString("dt_txt");
//				String[] split = dataResponseTime.split(" ");
//				String localDate = LocalDate.now().toString();
//
//				if (onlyToday) {
//					if (split[0].equals(localDate)) {
//						forecastWeatherDetails = getForecastWeatherDetails(object, onlyToday);
//					} else {
//						break;
////						return forecastWeather;
//					}
//				} else {
//				}
				forecastWeatherDetails = getForecastWeatherDetails(object, onlyToday);

				forecastWeatherDetailsList.add(forecastWeatherDetails);
			}
			forecastWeather.setForecastWeatherDetails(forecastWeatherDetailsList);

		}

		return forecastWeather;
	}

	private String getAPI(String name) {
		int count = 40;
		return "https://api.openweathermap.org/data/2.5/forecast?q=" + name + "&units=metric&cnt=" + count
				+ "&appid=e4961a86c1756902cecfd5cedf8215e7";
	}

	private ForecastWeatherDetails getForecastWeatherDetails(JSONObject object, boolean onlyToday) {
		ForecastWeatherDetails forecastWeatherDetails = new ForecastWeatherDetails();
		JSONObject weather = object.getJSONArray("weather").getJSONObject(0);

		forecastWeatherDetails.setWeatherMain(weather.getString("main"));
		forecastWeatherDetails.setWeatherDesc(weather.getString("description"));
		String icon = weather.getString("icon") + ".png";
		forecastWeatherDetails.setWeatherIcon(icon);

		forecastWeatherDetails.setForecastDataResponseTime(getDateTime(object.getString("dt_txt")));
		forecastWeatherDetails.setWeatherDetails(getWeatherDetails(object));
		
		return forecastWeatherDetails;
	}

	private String getDateTime(String string) {
		String[] dateTime = string.split(" ");
		String date = dateTime[0];
		String[] tempDate = date.split("-");
		
		String month = Month.of(Integer.parseInt(tempDate[1])).name().substring(0, 3);
		date = tempDate[2]+" "+month.substring(0, 1).toUpperCase() + month.substring(1);
		
//		Date localDate = new Date(date);
//		SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM \nHH:mm ");
		
		String time = dateTime[1];
		String[] tempTime = time.split(":");
		time = tempTime[0]+":"+tempTime[1];
		
		string = date +"\n"+time;
		return string;
	}

	private WeatherDetails getWeatherDetails(JSONObject object) {
		WeatherDetails weatherDetails = new WeatherDetails();

		JSONObject coordObject = jsonResponseObject.getJSONObject("city").getJSONObject("coord");

		weatherDetails.setLongitude(coordObject.getDouble("lon"));
		weatherDetails.setLatitude(coordObject.getDouble("lat"));

		JSONObject mainObject = object.getJSONObject("main");
		Double celcTemp = mainObject.getDouble("temp");
		Double fehTemp = (9.0 / 5.0) * celcTemp + 32;

		weatherDetails.setCelciusTemp(celcTemp.intValue()+""+'\u2032' + " C");
		weatherDetails.setFehrenhiteTemp(fehTemp.intValue()+""+'\u2032' + " F");

		weatherDetails.setTempFeelsLike(mainObject.getDouble("feels_like")+" "+'\u2032' + "C");
		weatherDetails.setPressure(mainObject.getInt("pressure") + " hPa");
		weatherDetails.setHumidity(mainObject.getInt("humidity") + "%");

		return weatherDetails;
	}

	public ForecastWeather returnDummyForecast() {
		String icon = "http://openweathermap.org/img/wn/01n.png";
		WeatherDetails weatherDetails = new WeatherDetails("N/A", "N/A", "N/A", "N/A", "N/A", 0.0, 0.0);
		ForecastWeatherDetails forecastWeatherDetails = new ForecastWeatherDetails("N/A", "N/A", icon, weatherDetails,
				"N/A");
		ForecastWeather forecastWeather = new ForecastWeather("N/A", "N/A", "Invalid City/State Name/Code!",
				Arrays.asList(forecastWeatherDetails));

		return forecastWeather;
	}
}
