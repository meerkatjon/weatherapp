package com.projects.weatherApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projects.weatherApp.model.WeatherResponse.Main;

//import model.WeatherResponse.Main;
//import model.WeatherResponse.Weather;

public class WeatherResponse {
	

	private String name;
	private Main main;
	
	public static class Main {
		 private double temp;
		 private int humidity;
		 
		  public double getTemp() {
		        return temp;
		    }

		    public void setTemp(double temp) {
		        this.temp = temp;
		    }

		    public int getHumidity() {
		        return humidity;
		    }

		    public void setHumidity(int humidity) {
		        this.humidity = humidity;
		    }

	}
		public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    
	    public Main getMain() {
			return main;
		}

		public void setMain(Main main) {
			this.main = main;
		}
  
}
