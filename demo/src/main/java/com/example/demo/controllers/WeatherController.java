package com.example.demo.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.WeatherService;
import com.example.demo.models.*;

@RestController
@RequestMapping("/api/v1")
public class WeatherController {

	WeatherService weatherService;
	
	public WeatherController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}
	
	@GetMapping("/weather-details")
	public ResponseEntity<List<Weather>> getWeatherReport() {
		List<Weather> w = weatherService.getAllWeatherFromDB();
		return ResponseEntity.ok(w);
	}
	
	/*
	 * @GetMapping("/weather-details/{loc}") public String
	 * getWeatherForLocation(@RequestParam String loc){
	 * 
	 * 
	 * 
	 * }
	 */
	@PostMapping("/weather")
	public ResponseEntity<Weather> saveWeather(@RequestParam String loc, @RequestParam double temp ) {
		Weather w = new Weather();
		
		w.setTemp(temp);
		w.setLoc(loc);
		w.setDate(LocalDateTime.now());
		
		 weatherService.postWeather(w);
		 
		 return ResponseEntity.ok(w);
	}
	
	//todo: write a put mapping
	@PutMapping("/weather")
	public void changeWeather(@RequestParam String loc, @RequestParam double temp){
		//Weather w = weatherService.changeWeather(loc, temp);
		Optional<Weather> w  = weatherService.changeWeather(loc, temp);
		
		
	}
	
	
}
