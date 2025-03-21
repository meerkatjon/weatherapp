package com.projects.weatherApp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.projects.weatherApp.model.WeatherResponse;

@Service
public class WeatherService {
	@Value("${weather.api.key}")
	private String apiKey;
	
	@Value("${weather.api.url}")
	private String apiUrl;
	
	private final RestTemplate restTemplate;
	
	public WeatherService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public WeatherResponse getWeather(String city) {
		String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey +"&units=metric";
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, WeatherResponse.class);
		
		//return weatherResponse;
		
	}
}
