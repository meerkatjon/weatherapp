package com.projects.weatherApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.projects.weatherApp.model.WeatherResponse;
import com.projects.weatherApp.service.WeatherService;

@Controller
public class WeatherController {
	@Value("${weather.api.key}")
	public String apiKey;
    @Autowired
    private WeatherService weatherService;
    
    public WeatherController(WeatherService weatherService) {
    	this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String getIndex() {
    	return "index";
    }
    @GetMapping("/weather")
    public String getWeather(@RequestParam(name = "city") String city, Model model) {
        // Get the weather data from the service
    	    WeatherResponse weatherResponse = weatherService.getWeather(city);
    	 
        // Add attributes to be displayed in the Thymeleaf template
        if(weatherResponse!=null) {
	        model.addAttribute("city", weatherResponse.getName());
	        model.addAttribute("temperature", weatherResponse.getMain().getTemp());
	        model.addAttribute("humidity", weatherResponse.getMain().getHumidity());
	        System.out.println("===============================================");
	        System.out.println("temp: "+weatherResponse.getMain().getTemp());
	        System.out.println("===============================================");
	         }
        else {
    		model.addAttribute("error", "city not found");
    	}
        return "weather";
		
    }
}
