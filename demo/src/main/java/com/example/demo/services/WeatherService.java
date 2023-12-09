package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.repository.WeatherRepository;
import com.example.demo.models.*;
/*
 * Contains all blocking operations
 * A thread (platfrom/OS) waits or remain idle consuming physical resources
 * till db exec is completed..
 * */
@Service
public class WeatherService {
	
	private WeatherRepository repository;
	
	//injection
	public WeatherService(WeatherRepository repository) {
		this.repository = repository;
	}
	
	//select * from weather
	public List<Weather> getAllWeatherFromDB(){	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return repository.findAll();
	}
	
	//insert into weather() values()
	public void postWeather(Weather w) {
		repository.save(w);
	}
	
	//updates w/o NPE
	public Optional<Weather> changeWeather(String loc,double val) {
		List<Weather> w = getAllWeatherFromDB();
		for(Weather weather:w) {
			if(weather.getLoc().equalsIgnoreCase(loc)) {
				weather.setTemp(val);
				postWeather(weather);
				return Optional.of(weather);
			}
		}
		return Optional.empty();
	}
	
	//where clause
	public Optional<String> getWeatherDetailsByLoc(String loc) {
		List<Weather> w = getAllWeatherFromDB(); 
		for(Weather weather:w) {
			if(weather.getLoc().equalsIgnoreCase(loc)) {
				return Optional.ofNullable(weather.toString());
			}
		}
		return Optional.empty();
	}


}
