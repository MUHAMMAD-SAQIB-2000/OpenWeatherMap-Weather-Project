package com.weatherApp.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class WeatherAppService {

	private OkHttpClient client;
	private Response response;
	private JSONObject jsonObjectResponse;

	public JSONObject getWeatherAPIData(String API) throws Exception {
		client = new OkHttpClient();
		Request request = new Request.Builder().url(API).build();
		response = client.newCall(request).execute();
		jsonObjectResponse = new JSONObject(response.body().string());

		if (isJSONResponseValid(jsonObjectResponse)) {
			return jsonObjectResponse;
		}
		return null;
	}

//	Checking for all error response codes
	private boolean isJSONResponseValid(JSONObject jsonObjectResponse) {
		String responseCode = Integer.toString(jsonObjectResponse.getInt("cod"));
		if (responseCode.equals("200")) {
			return true;
		} else if (responseCode.equals("401") || responseCode.equals("404") || responseCode.equals("429")
				|| responseCode.equals("500") || responseCode.equals("502") || responseCode.equals("503")
				|| responseCode.equals("504")) {
			return false;
		}
		return false;
	}

}
