package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.WeatherResponse;
import service.WeatherService;

@Controller
public class WeatherController {
	@Value("${weather.api.key}")
	private String apiKey;
	
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
	public String getWeather(@RequestParam (name="city") String city, Model model) {
		WeatherResponse weather = weatherService.getWeather(city, apiKey);
		
		model.addAttribute("city", weather.getName());
		model.addAttribute("temperature", weather.getMain().getTemp());
		model.addAttribute("humidity", weather.getMain().getHumidity());
		return "index";
	}
	
}
