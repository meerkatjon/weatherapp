package service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import model.WeatherResponse;

public class WeatherService {
	@Value("${weather.api.key}")
	private String apiKey;
	
	@Value("${weather.api.url}")
	private String apiUrl;

	public WeatherResponse getWeather(String city,String apiKey) {
		String url = apiUrl + city +"&appId" + apiKey + "&units=metric";
		RestTemplate resttemplate = new RestTemplate();
		WeatherResponse weatherResponse = resttemplate.getForObject(url, WeatherResponse.class);
		
		return weatherResponse;
		
	}
}
